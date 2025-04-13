# 🧾 E-Commerce Payment Gateway & Product Service

This project is a modular **microservices-based** application built to handle product management and payment processing for an e-commerce platform.

It comprises two main services:

## 1. 🔌 Payment Gateway Service
This microservice is responsible for handling payment operations and is seamlessly integrated with **Razorpay**.

### Features:
- Razorpay integration for secure and fast payments.
- Order creation and tracking.
- Webhook support for payment status updates.
- Error handling and logging for failed transactions.
- Easy configuration using environment variables.

### Tech Stack:
- Java (Spring Boot)
- Razorpay SDK
- RESTful APIs

## 2. 📦 Product Service
The Product Service manages product data and allows users to explore available products by category or unique product ID.

### Features:
- Add new products with essential metadata.
- Retrieve product details by ID.
- List all products under a specific category.
- Input validation and structured error handling.

### Tech Stack:
- Java (Spring Boot)
- RESTful APIs
- In-memory or persistent database (e.g., H2, PostgreSQL)

