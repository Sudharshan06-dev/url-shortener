🚀 URL Shortener with Spring Boot, MongoDB, Zookeeper, and React

Welcome to the URL Shortener project! This is a fun, robust, and easy-to-deploy URL shortening service that allows users to generate short links for long URLs. It utilizes a microservice architecture with Spring Boot for the backend, React for the frontend, MongoDB for storage, and Zookeeper for service coordination. The entire application is containerized using Docker and orchestrated with Kubernetes (k8s) for scalability and flexibility. This project is a reimagined version or taken inspiration of an existing URL shortener (https://github.com/muKaustav/ShortURL), refactored with modern technologies like MongoDB, Spring Boot, and more to enhance performance, scalability, and flexibility.

📌 Features

Custom URL Shortening: Create custom short URLs for any given long link.
Short URL Redirection: Automatically redirects short URLs to the original long URLs.
User-Friendly Interface: A simple and intuitive React-based frontend.
Scalable and Reliable: With Zookeeper and Kubernetes, this service can scale with ease.
Lightweight and Fast: A minimalistic backend service using Spring Boot, designed for quick responses.
Persistent Storage: URLs are stored in MongoDB for persistence.


💻 Technologies Used

Backend: Spring Boot (Java)
Frontend: React
Database: MongoDB, Redis
Service Coordination: Zookeeper
Containerization: Docker
Orchestration: Kubernetes (k8s)
Build Tools: Maven, Webpack
Version Control: Git


⚡ Quick Start
Ready to start your own URL Shortener? Here are the simple steps to get this project up and running locally:

1. Clone the repository
  Navigate the directory:

  bash
  Copy code
  [git clone https://github.com/your-username/url-shortener.git](https://github.com/Sudharshan06-dev/url-shortener.git)
  cd url-shortener

2. Set up the Backend
  Navigate to the backend directory:

  bash
  Copy code
  cd server/url-shortener
  Build and run the Spring Boot application:
  
  bash
  Copy code
  ./mvnw spring-boot:run
  The backend will be available at http://localhost:8080.

3. Set up the Frontend
  Navigate to the frontend directory:

  bash
  Copy code
  cd ../client/url-shortener
  Install the dependencies:
  
  bash
  Copy code
  npm install
  Run the React development server:
  
  bash
  Copy code
  npm start
  The frontend will be available at http://localhost:3000.

4. Containerize the Application with Docker
  Both the backend and frontend are Dockerized for easy deployment.
  
  Build the Docker images:
  
  bash
  Copy code
  docker-compose build
  Start the containers:
  
  bash
  Copy code
  docker-compose up
  The application will run with both backend and frontend containers ready to go!

5. Scale with Kubernetes
  For scaling the application, you can deploy it using Kubernetes. The project includes the necessary configuration files (deployment.yaml, service.yaml) for easy setup in a k8s environment.
  
  bash
  Copy code
  kubectl apply -f k8s/


🛠️ How It Works
Frontend (React): Users input their long URLs into the frontend interface. The application makes API calls to the backend to shorten the URL.

Backend (Spring Boot): The backend receives the long URL, generates a unique short URL, and saves the mapping in the MongoDB database.

MongoDB: Stores the long URL and its corresponding shortened version.

Zookeeper: Coordinates services for distributed architecture to ensure reliability and synchronization between backend microservices.

🤝 Contributing
I welcome contributions to improve and extend this project! Whether you're fixing a bug, adding a new feature, or simply improving documentation, feel free to open an issue or submit a pull request.

Steps to contribute:
Fork the repository.
Create a new branch (git checkout -b feature-name).
Make your changes and commit (git commit -am 'Add feature').
Push your changes to your fork (git push origin feature-name).
Open a pull request!

📫 Connect with Me
LinkedIn - https://www.linkedin.com/in/sudharshan06-dev/
Feel free to connect with me on LinkedIn for networking, collaborations, and discussions.

Resume - https://drive.google.com/file/d/1qbdlZaW0wa-LOWM6Yz3X1_JBy-rUPi7w/view?usp=sharing
You can view or download my resume here for further details on my experience and skills.

📄 License
This project is licensed under the MIT License – see the LICENSE file for details.

💬 Support
If you have any questions or need assistance, feel free to open an issue on GitHub or reach out to me directly at your-email@example.com.

🚀 Go ahead and try it out!
Start shortening your URLs with ease! And feel free to contribute if you want to help make this project even better.
