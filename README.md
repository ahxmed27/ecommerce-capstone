E-Commerce API – Spring Boot Backend

A RESTful backend API for an e-commerce application built with Spring Boot and MySQL.
This project was completed as part of a Java Development capstone and focuses on category management and fixing critical product-related bugs in an existing API.

📋 Table of Contents

Project Scope

Technologies Used

Implemented Features

Authentication

API Endpoints

Bug Fixes

Testing

🎯 Project Scope

This capstone builds upon an existing Spring Boot API.
Work completed for this project includes:

Phase 1: Full implementation of the CategoriesController and DAO

Phase 2: Identification and resolution of product-related bugs

No front-end development was required; all changes were made in the backend API.

🛠 Technologies Used

Java

Spring Boot

Spring Security

JWT Authentication

MySQL

Insomnia

✨ Implemented Features
Category Management (Phase 1)

Retrieve all categories

Retrieve a category by ID

Create new categories (Admin only)

Update existing categories (Admin only)

Delete categories (Admin only)

Categories stored and managed in a MySQL database

Product Bug Fixes (Phase 2)

Fixed product search and filtering logic to return accurate results

Corrected update behavior to prevent duplicate products from being created

Ensured product updates properly modify existing records instead of inserting new ones

🔐 Authentication

JWT-based authentication

Secure login and registration endpoints

Role-based access control:

ADMIN: Can create, update, and delete categories and products

USER: Read-only access

All protected endpoints require a valid JWT token.

🌐 API Endpoints
Categories
Method	Endpoint	Description	Access
GET	/categories	Get all categories	Public
GET	/categories/{id}	Get category by ID	Public
POST	/categories	Create a category	Admin
PUT	/categories/{id}	Update a category	Admin
DELETE	/categories/{id}	Delete a category	Admin
Products (Bug Fixes Only)
Method	Endpoint	Description	Access
GET	/products	Search / filter products	Public
GET	/products/{id}	Get product by ID	Public
PUT	/products/{id}	Update product (fixed)	Admin
🐞 Bug Fixes

Resolved incorrect search results when filtering by category, price range, and subcategory

Fixed product update logic that previously inserted duplicate products instead of updating existing ones

🧪 Testing

Manual testing using Insomnia

Verified category CRUD functionality

Validated corrected product search behavior

Confirmed product updates no longer create duplicate records

Screenshots of application and Insomnia Testing
<img width="2017" height="1143" alt="image" src="https://github.com/user-attachments/assets/edd5b08c-dba2-4a9a-beba-04a8e50727db" />

<img width="1891" height="853" alt="image" src="https://github.com/user-attachments/assets/a0de7984-3f4f-4eba-998b-8c884719ae73" />


<img width="2000" height="984" alt="image" src="https://github.com/user-attachments/assets/468025ff-3f9b-41de-9bbb-10d08b0b6126" />


<img width="2000" height="985" alt="image" src="https://github.com/user-attachments/assets/22ec1bd9-968f-49e5-8a48-3a33b33a97f3" />


<img width="2000" height="1016" alt="image" src="https://github.com/user-attachments/assets/ccf3f7c9-1336-4cc8-bfec-834cebc10375" />



