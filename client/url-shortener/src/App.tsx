import React from 'react';
import './App.css';
import UrlInput from "./components/url-input/url-input";
import ShortUrlHeader from "./header/header";
import ShortUrlFooter from "./footer/footer";

function App() {
    return (

        <div className="App">
            <div className="min-h-screen flex flex-col bg-gradient-to-r from-[#516395] to-[#614385]">

                <ShortUrlHeader/>
                <UrlInput/>
                <ShortUrlFooter/>

            </div>

        </div>
    );
}

export default App;
