# 🔐 Refresh Token Authentication System (Spring Boot)

This project demonstrates a **production-ready JWT Authentication system** implemented with **Access Token + Refresh Token architecture** using Spring Boot.

It covers not only basic JWT usage, but also a **secure, scalable, and real-world authentication flow**.

---

## 🚀 Features

- JWT-based authentication (Access Token)
- Refresh Token mechanism (DB-backed, revocable)
- Secure login & registration flow
- Token refresh endpoint
- Logout with token revocation
- Stateless security (Spring Security + JWT filter)
- Global exception handling (clean API responses)
- Simple UI with Thymeleaf (Login / Register / Dashboard)
- H2 in-memory database for quick setup

---

## 🧠 Architecture Overview

### Token Strategy

| Token Type   | Storage      | Purpose                         |
|--------------|--------------|---------------------------------|
| Access Token | Client (JS)  | Short-lived authentication      |
| Refresh Token| Database     | Long-lived, revocable token     |

---

### Flow

```text
1. Register / Login
   → Access Token generated
   → Refresh Token generated & saved in DB

2. Access protected endpoints
   → Access Token used (Authorization: Bearer)

3. Access Token expires
   → Client calls /refresh with Refresh Token

4. Server validates Refresh Token
   → New Access Token returned

5. Logout
   → Refresh Token is revoked in DB

6. Reuse revoked token
   → Request is rejected

🏗️ Tech Stack

Java 21
Spring Boot 3.x
Spring Security
Spring Data JPA
Hibernate
H2 Database
Thymeleaf
JJWT (JWT handling)
Lombok

📁 Project Structure

com.velihan.refreshtokenauth
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── repository
├── security
├── service
└── templates

⚙️ Configuration

app:
  jwt:
    secret: your-very-secure-secret-key
    access-token-expiration-ms: 900000
    refresh-token-expiration-ms: 604800000

🔑 API Endpoints

Auth Endpoints

Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Login
POST	/api/auth/refresh	Refresh access token
POST	/api/auth/logout	Revoke refresh token

Protected Endpoint

Method	Endpoint	Description
GET	/api/demo/me	Get current user

🧪 Example Requests

Register

POST /api/auth/register

{
  "email": "test@test.com",
  "password": "123456"
}

Login

POST /api/auth/login
{
  "email": "test@test.com",
  "password": "123456"
}

Refresh Token

POST /api/auth/refresh
{
  "refreshToken": "uuid-token"
}

Logout

POST /api/auth/logout
{
  "refreshToken": "uuid-token"
}

🛡️ Security Details

Passwords are hashed using BCrypt
JWT tokens are signed using HMAC-SHA
Refresh tokens:
Stored in DB
Expirable
Revocable (logout support)
Stateless authentication via Spring Security

⚠️ Important Design Decisions

Refresh Token is NOT JWT
Stored in DB
Revocable
More secure than JWT-based refresh tokens
JWT Filter Bypass
/api/auth/**

Reason:

Refresh should work even when access token is expired.

Lazy Loading Fix

@EntityGraph used to fetch User with RefreshToken

Prevents:

LazyInitializationException

🧩 UI Pages

/login
/register
/dashboard

Features:

Login & register forms
Token stored in localStorage
Refresh token button
Logout functionality

🗄️ Database (H2)

H2 Console:

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:refresh_token_auth

📌 Future Improvements

Refresh Token Rotation
Role-based authorization (ADMIN / USER)
PostgreSQL integration
Dockerization
Swagger / OpenAPI
Redis token store

👨‍💻 Author

Velihan Gözek
Backend Engineer (Java & Spring Boot)

⭐ Summary

This project demonstrates:

Real-world authentication design
Secure token lifecycle management
Clean architecture & best practices