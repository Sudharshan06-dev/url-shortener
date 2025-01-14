package com.url_shortener.service;

import java.nio.charset.StandardCharsets;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ZookeeperService {

    @Value("${zookeeper.server}")
    private String zookeeperServer;

    private ZooKeeper zkClient;

    private final String tokenNodePath = "/token";

    private Range range = new Range();

    public void connectZk() throws Exception {
        zkClient = new ZooKeeper(zookeeperServer, 3000, event -> {
            
            if(event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                System.out.println("Connected to ZooKeeper server.");
            } else {

                try {
                    checkIfTokenExists();
                    getTokenRange();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public void createToken() throws Exception {
        byte[] buffer = "0".getBytes(StandardCharsets.UTF_8);

        try {
            zkClient.create(tokenNodePath, buffer, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("Node created at: " + tokenNodePath);
        } catch (KeeperException.NodeExistsException e) {
            System.out.println("Node already exists.");
            e.printStackTrace();
        }
    }

    public void checkIfTokenExists() throws Exception {
        Stat stat  = zkClient.exists(tokenNodePath, false);

        if(stat == null) {
            createToken();
        } else {
            System.out.println("Node exists: " + tokenNodePath);
        }
    }

    public void setTokenRange(int token) throws Exception {
        byte[] data = String.valueOf(token).getBytes(StandardCharsets.UTF_8);
        zkClient.setData(tokenNodePath, data, -1);
        System.out.println("Data is set to: " + token);
    }

    public void getTokenRange() throws Exception {
        Stat stat = new Stat();
        byte[] data = zkClient.getData(tokenNodePath, false, stat);
        int start = Integer.parseInt(new String(data, StandardCharsets.UTF_8)) + 1000000;
        range.setStart(start);
        range.setCurr(start);
        range.setEnd(start+ 1000000);

        setTokenRange(range.getStart());
    }

    public void removeToken() throws Exception {
        zkClient.delete(tokenNodePath, -1);
        System.out.println("Node deleted: " + tokenNodePath);
    }

    public String hashGenerator(int n) {
        char[] hash = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder hashStr = new StringBuilder();

        while (n > 0) {
            hashStr.append(hash[n % 62]);
            n /= 62;
        }

        String hashString = hashStr.reverse().toString();

        while (hashString.length() < 8) {
            hashString += '=';
        }

        return hashString;
    }



    public static class Range {
        private int start;
        private int curr;
        private int end;
        
        public int getStart() {return start;}
        public void setStart(int start) {this.start = start;}
        public int getCurr() {return curr;}
        public void setCurr(int curr) {this.curr = curr;}
        public int getEnd() {return end;}
        public void setEnd(int end) {this.end = end;}

    }

}
