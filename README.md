# Yeet! - Android Chat Application

## Table of Contents
* [Project Description](#description)
* [Getting Started](#Getting-Started)
* [Application Overview](#application-overview)
* [Server Implementation](#server-implementation)
* [Contributors](#contributors)
  
## Description
Welcome to the `Yeet!` project! This Git repository contains the source code for an Android application that enables users to access the Yeet! chat system. Built using Java and XML, this Android client provides a seamless and intuitive mobile experience for interacting with contacts, engaging in real-time conversations, and exchanging messages.

## Getting Started
To get started with the web chat application, follow these steps:  
1. Clone the Git repository to your local machine using the command : `git clone https://github.com/aliktepl/yeet-chat-application.git`  
2. To start the server navigate the the `/server` directory in the project directory and run the following command: `npm install` - this will install all the required dependencies. After that, run `npm start`.    
3. Launch the Android emulator of your choice or connect a physical Android device to your computer.

Once you have followed these steps, you will be able to use the Yeet! Android chat application and start communicating with other users.  
Enjoy Yeeting!  

## Application Overview
The chat application is divided into different parts to ensure a smooth user experience:  

#### Login Screen:  
Allows users to enter their login credentials to gain access to the chat application. If a user doesn't have an account, they can refer to the sign-up screen to create a new account. The login screen ensures secure authentication for users. 
#### Sign-up Screen:  
Provides a user-friendly interface for creating a new account. Users can provide the necessary information and register for an account. Once the account is created, they can proceed to the login screen to access the chat application.
#### Contacts Screen:  
After successful login, users are transferred to the Chats screen. This screen displays a list of contacts that the user has added. Users can view their contacts, initiate conversations, and manage their contact list. In addition, the contacts screen provides additional functionality:
  - By performing a long press on a contact, users can delete the chat conversation with that contact.
  - By clicking the "More" button (represented by three dots), users can access a menu that provides additional options.   
This menu includes the following:
    * Settings: Users can navigate to the settings screen by selecting the "Settings" option from the menu.
    * Logout: Users can choose the "Logout" option from the menu to securely log out from their account. This action will terminate the current session and return them to the login screen, ensuring the privacy and security of their account.
#### Settings Screen:
The settings screen provides users with the ability to customize various aspects of the application according to their preferences. It includes the following options:  
* Server Address: Users can edit the address of the server they are working with on this screen. This allows them to connect to a specific server or update the server address as needed.
* Night Mode Switch: The "Night Mode" switch allows users to toggle between different themes for the application. Enabling the night mode theme provides a darker color scheme, which can enhance visibility and reduce eye strain in low-light environments. 
#### Chat Screen:  
After selecting a contact from the contacts list, users are taken to the chat screen. This screen allows users to engage in real-time text conversations with the selected contact. Users can send messages and receive replies in a seamless manner. 

## Server Implementation
The server-side implementation of the Yeet! chat application follows the Model-View-Controller (MVC) architectural pattern and integrates with MongoDB for efficient data storage. The server plays a crucial role in handling client requests, managing data interactions, and enabling real-time communication between users.  

#### Part 1: Client-Server Interaction  
All application components work seamlessly with the API defined in the previous exercise. This includes registration, login, managing contacts, engaging in chats, and sending/receiving messages. The server API handles these requests and provides relevant information to the application. Similarly, the application sends the necessary data to the server API for appropriate processing.  
#### Part 2: Local Data Storage and Synchronization  
The Android application saves a local copy of chats, messages, and other relevant information. It utilizes Room, a local SQLite database, to store this data. When the application is launched, it extracts the required information from the local database. In the background, synchronization is performed with the server. The server's response updates the local database, ensuring that the visual interface reflects the most recent data.  
#### Part 3: Real-time Communication
The server implements push notifications to deliver messages to clients using Firebase. Firebase's push notification functionality is leveraged to send notifications to the Android client. When a user receives a message, the server pushes the notification to the respective client device using Firebase's push notification service. This ensures that users are instantly notified of new messages, even if the application is not actively running.  

## Contributors
- [Roy Amit](https://github.com/royamit1)  
- [Alik Teplitsky](https://github.com/aliktepl)
- [Roi Nir](https://github.com/roini7)

