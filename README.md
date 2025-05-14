
# **Java Console-Based Chat Application**

**Company**: CODETECH IT SOLUTIONS

**Name**: SAISRI DASARI

**Intern ID**: CT04DK210

**Domain**: JAVA DEVELOPER

**Duration**: 4 WEEKS

**Mentor**: NEELA SANTOSH

---

### 📌 **Project Description**

This Java project is a **console-based multi-user chat application** that allows multiple clients to connect and communicate via a common server. It demonstrates client-server architecture and real-time communication using sockets.

The application consists of:

1. **Server** (`MyChatServer.java`)
2. **Client** (`MyChatClient.java`)

Users can:

* Enter their name to join the chat
* Send and receive messages in real-time
* View notifications when a user joins or leaves

The project showcases:

* Socket programming using `java.net.Socket` and `java.net.ServerSocket`
* Multi-threading using `Thread` to handle multiple users
* I/O operations using `BufferedReader` and `PrintWriter`
* Synchronized message broadcasting across all connected clients

---

### 🛠️ **Technologies Used**

* Java (JDK 8 or higher)
* Socket Programming
* Multi-threading
* Console I/O

---

### 📥 **How It Works**

#### 🖥️ Server (`MyChatServer.java`)

* Starts on port `9090`
* Accepts incoming client connections
* Creates a new thread (`UserHandler`) for each client
* Broadcasts messages to all users except the sender

#### 💬 Client (`MyChatClient.java`)

* Connects to `localhost` on port `9090`
* Sends user input to the server
* Receives and prints broadcast messages from the server

---


### 📷 **Output Screenshot**
![Image](https://github.com/user-attachments/assets/cb02f550-8515-4528-bc7e-13a7db63d77d)
