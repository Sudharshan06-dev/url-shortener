
# 🚀 URL Shortener with Spring Boot, MongoDB, Zookeeper, and React  

Welcome to the **URL Shortener** project! This is a **robust, scalable, and easy-to-deploy** URL shortening service that allows users to generate short links from long URLs.  

This application follows a **microservices architecture**, with:
- **Spring Boot** for the backend  
- **React** for the frontend  
- **MongoDB** for persistent storage  
- **Redis** for caching  
- **Zookeeper** for service coordination  

The entire application is **containerized with Docker** and **orchestrated using Kubernetes (k8s)** for better scalability and reliability.  

This project is inspired by an existing [URL shortener](https://github.com/muKaustav/ShortURL) but has been **refactored with modern technologies** like **Spring Boot, MongoDB, Redis, and Kubernetes** to enhance performance, flexibility, and maintainability.  

---

## 📌 Features  
✔ **Custom URL Shortening** – Generate short URLs from long links  
✔ **Short URL Redirection** – Automatically redirect short URLs to their original destination  
✔ **User-Friendly Interface** – A simple and intuitive **React-based frontend**  
✔ **Scalability & Reliability** – Powered by **Zookeeper and Kubernetes** for distributed architecture  
✔ **Lightning Fast** – A minimalistic **Spring Boot backend** designed for quick responses  
✔ **Persistent Storage** – URLs are stored in **MongoDB**  

---

## 💻 Technologies Used  
- **Backend:** Spring Boot (Java)  
- **Frontend:** React  
- **Database:** MongoDB, Redis  
- **Service Coordination:** Zookeeper  
- **Containerization:** Docker  
- **Orchestration:** Kubernetes (k8s)  
- **Build Tools:** Maven, Webpack  
- **Version Control:** Git  

---

## ⚡ Quick Start  

### **1. Clone the Repository**  
```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

### **2. Set up the Backend**  
Navigate to the backend directory:  
```bash
cd server/url-shortener
```
Build and run the Spring Boot application:  
```bash
./mvnw spring-boot:run
```
The backend will be available at: [http://localhost:8080](http://localhost:8080)  

### **3. Set up the Frontend**  
Navigate to the frontend directory:  
```bash
cd ../client/url-shortener
```
Install the dependencies:  
```bash
npm install
```
Run the React development server:  
```bash
npm start
```
The frontend will be available at: [http://localhost:3000](http://localhost:3000)  

### **4. Containerize the Application with Docker**  
Both backend and frontend are **Dockerized** for easy deployment.  

Build the Docker images:  
```bash
docker-compose build
```
Start the containers:  
```bash
docker-compose up
```
Now the **backend and frontend containers** are running! 🚀  

### **5. Scale with Kubernetes**  
For scaling, deploy the application using **Kubernetes**. The required configuration files (**deployment.yaml, service.yaml**) are included.  

Run the following command to deploy:  
```bash
kubectl apply -f k8s/
```

---

## 🛠️ How It Works  

### **Frontend (React)**  
- Users input their long URLs in the frontend interface.  
- The application makes API calls to the backend to generate a shortened URL.  

### **Backend (Spring Boot)**  
- The backend receives the long URL, generates a **unique short URL**, and saves the mapping in **MongoDB**.  

### **MongoDB**  
- Stores the **long URL** and its corresponding **shortened version**.  

### **Zookeeper**  
- Coordinates services for **distributed architecture**, ensuring **reliability and synchronization** between backend microservices.  

---

## 🤝 Contributing  

I welcome contributions to improve and extend this project! Whether you’re **fixing bugs, adding features, or improving documentation**, feel free to **open an issue** or **submit a pull request**.  

### **Steps to Contribute:**  
1. **Fork** the repository.  
2. Create a **new branch**:  
   ```bash
   git checkout -b feature-name
   ```
3. Make changes and **commit**:  
   ```bash
   git commit -am "Added feature XYZ"
   ```
4. **Push** changes to your fork:  
   ```bash
   git push origin feature-name
   ```
5. Open a **Pull Request (PR)** and submit your changes!  

---

## 📫 Connect with Me  

**🔗 LinkedIn** – [Sudharshan06-dev](https://www.linkedin.com/in/sudharshan06-dev/)  
**📄 Resume** – [Download Resume](https://drive.google.com/file/d/1qbdlZaW0wa-LOWM6Yz3X1_JBy-rUPi7w/view?usp=sharing)  

---

## 📄 License  

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.  

---

## 💬 Support  

If you have **any questions** or need **assistance**, feel free to:  
- **Open an issue** on GitHub  
- **Reach out via email** at **sudharshan.madhav@gmail.com**  

---

## 🚀 Try It Out!  

Start shortening your URLs with ease!  
And if you’d like to **help improve this project**, feel free to contribute. 🎉 
