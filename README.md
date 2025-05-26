🎵 Go Tune
<div align="center">
Show Image
Show Image
Show Image
Show Image
Show Image
Show Image
🎸 Premium Music Instrument E-Commerce Platform
Enterprise-grade microservices architecture built with Go, gRPC & modern distributed technologies
🚀 Quick Start • 🏗️ Architecture • 📖 API Docs • 👥 Team

</div>
✨ Key Features
<table>
<tr>
<td width="50%">
🔐 User Management

🎯 JWT-based authentication system
📧 Email verification workflow
🔒 Secure password hashing
👤 User profile management
⚡ Redis session caching

🎸 Instrument Catalog

📝 Full CRUD operations
🔍 Advanced search & filtering
💾 MongoDB document storage
🚀 Redis performance caching
📊 Real-time inventory tracking

</td>
<td width="50%">
🛒 Shopping Experience

🛍️ Real-time cart management
⚡ Redis-backed cart persistence
🔄 Cross-device cart sync
💳 Seamless checkout flow

📦 Order Processing

🎯 Event-driven order workflow
📨 RabbitMQ message queuing
📧 Automated email notifications
📊 Order status tracking
💼 Admin order management

</td>
</tr>
</table>

🏗️ System Architecture
<div align="center">
mermaidgraph TB
    Client[🌐 Client Applications] --> Gateway[🚪 API Gateway :8081]
    
    Gateway --> UserSvc[👤 User Service :50051]
    Gateway --> InstrSvc[🎸 Instruments Service :50052] 
    Gateway --> CartSvc[🛒 Cart Service :50053]
    Gateway --> OrderSvc[📦 Orders Service :50054]
    
    UserSvc --> MongoDB1[(🍃 MongoDB<br/>gotune_users)]
    InstrSvc --> MongoDB2[(🍃 MongoDB<br/>gotune_instruments)]
    CartSvc --> MongoDB3[(🍃 MongoDB<br/>gotune_cart)]
    OrderSvc --> MongoDB4[(🍃 MongoDB<br/>gotune_order)]
    
    CartSvc --> Redis[(⚡ Redis Cache<br/>:6379)]
    OrderSvc --> Redis
    UserSvc --> Redis
    
    UserSvc --> RabbitMQ[🐰 RabbitMQ<br/>:5672]
    OrderSvc --> RabbitMQ
    CartSvc --> RabbitMQ
    
    RabbitMQ --> Consumer[📨 Event Consumer]
    Consumer --> SMTP[📧 SMTP Server]
    
    Gateway --> Prometheus[📊 Prometheus<br/>:9090]
    Prometheus --> Grafana[📈 Grafana<br/>:3000]
</div>
🎯 Microservices Overview
ServicePortDatabaseCacheDescription🚪 API Gateway:8081--Request routing, load balancing & authentication👤 User Service:50051gotune_users✅ RedisUser auth, profiles & email verification🎸 Instruments:50052gotune_instruments✅ RedisProduct catalog & inventory management🛒 Cart Service:50053gotune_cart✅ RedisShopping cart operations & persistence📦 Orders Service:50054gotune_order✅ RedisOrder processing & status tracking📨 Event Consumer---Email notifications & event processing

🚀 Technology Stack
<div align="center">
🔧 Backend & Communication
Show Image
Show Image
Show Image
💾 Databases & Storage
Show Image
Show Image
📨 Messaging & Events
Show Image
Show Image
📊 Monitoring & DevOps
Show Image
Show Image
Show Image
</div>

🚀 Quick Start
📋 Prerequisites
bash✅ Go 1.21+        ✅ Docker & Docker Compose    ✅ MongoDB 6.0+
✅ Redis 7.0+      ✅ RabbitMQ 3.12+            ✅ Git
⚡ Installation & Setup
<details>
<summary><b>🐳 Docker Setup (Recommended)</b></summary>
bash# 1. Clone the repository
git clone https://github.com/your-username/gotune.git
cd gotune

# 2. Start infrastructure services
docker-compose up -d mongodb redis rabbitmq

# 3. Wait for services to be ready (30-60 seconds)
docker-compose logs -f mongodb redis rabbitmq

# 4. Run database migrations
cd users && go run migrations/runner.go
cd ../cart && go run migrations/runner.go  
cd ../instruments && go run migrations/runner.go
cd ../order && go run migrations/runner.go

# 5. Start all microservices
docker-compose up -d
</details>
<details>
<summary><b>🛠️ Manual Development Setup</b></summary>
bash# 1. Clone and setup dependencies
git clone https://github.com/your-username/gotune.git
cd gotune
go mod download

# 2. Start infrastructure (requires Docker)
docker-compose up -d mongodb redis rabbitmq

# 3. Run database migrations
cd users && go run migrations/runner.go
cd ../cart && go run migrations/runner.go
cd ../instruments && go run migrations/runner.go  
cd ../order && go run migrations/runner.go
cd ..

# 4. Start services in separate terminals

# Terminal 1 - User Service
cd users/cmd && go run main.go

# Terminal 2 - Instruments Service  
cd instruments/cmd && go run main.go

# Terminal 3 - Cart Service
cd cart/cmd && go run main.go

# Terminal 4 - Orders Service
cd order/cmd && go run main.go

# Terminal 5 - API Gateway
cd api-gateway/cmd && go run main.go

# Terminal 6 - Event Consumer
cd consumer && go run main.go
</details>
🎯 Verify Installation
bash# Check API Gateway health
curl http://localhost:8081/users

# Check individual services
curl http://localhost:8081/instruments
curl http://localhost:8081/cart/get
curl http://localhost:8081/orders

📁 Project Structure
🎵 gotune/
├── 🚪 api-gateway/              # API Gateway Service
│   ├── cmd/main.go             # Gateway entry point
│   └── internal/
│       ├── client/             # gRPC service clients
│       └── handler/            # HTTP route handlers
├── 👤 users/                   # User Management Service
│   ├── cmd/main.go            # Service entry point
│   ├── internal/
│   │   ├── config/            # MongoDB connection
│   │   ├── entity/            # User domain models
│   │   ├── repository/        # Data access layer
│   │   └── service/           # Business logic
│   ├── migrations/            # Database migrations
│   └── proto/                 # gRPC definitions
├── 🎸 instruments/             # Instrument Catalog Service
│   ├── cmd/main.go
│   ├── internal/
│   │   ├── config/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── migrations/
│   └── proto/
├── 🛒 cart/                    # Shopping Cart Service
│   ├── cmd/main.go
│   ├── internal/
│   │   ├── config/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── migrations/
│   └── proto/
├── 📦 order/                   # Order Management Service
│   ├── cmd/main.go
│   ├── internal/
│   │   ├── config/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── migrations/
│   └── proto/
├── 📨 consumer/                # Event Consumer Service
│   └── main.go                # Email & event processing
├── 🎯 events/                  # Event Publishing System
│   └── publisher.go           # RabbitMQ event publisher
├── 🧪 test/                    # Test Suites
│   ├── integration/           # End-to-end tests
│   └── unit/                  # Service unit tests
├── 💾 dump.rdb                # Redis persistence file
├── 📄 go.mod                  # Go module definition
└── 🐳 docker-compose.yml      # Container orchestration

📖 API Documentation
🔐 Authentication Endpoints
MethodEndpointDescriptionBodyPOST/registerUser registration{"email", "password", "name", "phone"}POST/loginUser authentication{"email", "password"}POST/users/confirmEmail verification{"token", "email"}
👤 User Management
MethodEndpointDescriptionAuthGET/usersList all users🔓GET/users/{id}Get user by ID🔓PUT/users/{id}Update user profile🔒DELETE/users/{id}Delete user account🔒 AdminDELETE/users/cache/clearClear user cache🔒 Admin
🎸 Instrument Catalog
MethodEndpointDescriptionAuthGET/instrumentsList all instruments🔓GET/instruments/{id}Get instrument details🔓POST/instrumentsCreate new instrument🔒 AdminPUT/instruments/{id}Update instrument🔒 AdminDELETE/instruments/{id}Delete instrument🔒 AdminDELETE/instruments/cache/clearClear instrument cache🔒 Admin
🛒 Shopping Cart
MethodEndpointDescriptionAuthPOST/cart/addAdd item to cart🔒GET/cart/getRetrieve user cart🔒POST/cart/removeRemove cart item🔒POST/cart/clearClear entire cart🔒
📦 Order Management
MethodEndpointDescriptionAuthPOST/ordersCreate new order🔒GET/ordersGet user orders🔒DELETE/ordersCancel order🔒

🧪 Testing
🎯 Unit Testing
bash# Run all unit tests
go test ./...

# Test specific service with coverage
go test -cover ./users/internal/service/...
go test -cover ./cart/internal/repository/...

# Generate coverage report
go test -coverprofile=coverage.out ./...
go tool cover -html=coverage.out -o coverage.html
🔗 Integration Testing
bash# Run full integration test suite
go test ./test/integration/... -v

# Test with race condition detection
go test -race ./test/integration/...

# Test specific integration scenarios
go test ./test/integration/user_flow_test.go -v
go test ./test/integration/order_flow_test.go -v

🐰 Event-Driven Architecture
RabbitMQ Message Queue Events
Event TypePublisherConsumerPayloadDescriptionuser.registeredUser ServiceEmail Consumer{user_id, email, name}Welcome email triggeruser.verificationUser ServiceEmail Consumer{email, token, name}Email verificationcart.item.addedCart ServiceAnalytics Consumer{user_id, item_id, quantity}Cart analyticsorder.createdOrder ServiceEmail Consumer{order_id, user_id, total}Order confirmationorder.status.changedOrder ServiceNotification Consumer{order_id, status, user_id}Status updates
Event Publisher Usage
go// Publishing events from services
eventPublisher := events.NewEventPublish("amqp://guest:guest@localhost:5672/")

// Example: Publishing user registration event
eventPublisher.PublishEvent("user.registered", map[string]interface{}{
    "user_id": userID,
    "email":   email,
    "name":    name,
})

📊 Monitoring & Observability
<div align="center">
📈 Grafana Dashboards
URL: http://localhost:3000
Credentials: admin / admin
🎯 Prometheus Metrics
URL: http://localhost:9090
Scrape Endpoint: http://localhost:8081/metrics
</div>
<details>
<summary><b>📊 Available Metrics</b></summary>
Application Metrics

http_requests_total - Total HTTP requests by endpoint
http_request_duration_seconds - Request latency distribution
grpc_requests_total - gRPC service call metrics
active_users_count - Currently active user sessions

Infrastructure Metrics

mongodb_connections_active - Active MongoDB connections
redis_commands_total - Redis operations by command type
rabbitmq_messages_published - Published message count
rabbitmq_messages_consumed - Consumed message count

Business Metrics

orders_created_total - Orders created by status
cart_items_added_total - Items added to carts
user_registrations_total - New user registrations
instruments_viewed_total - Product page views

</details>

🗄️ Database Schema
<details>
<summary><b>📊 MongoDB Collections</b></summary>
Users Collection (gotune_users.users)
json{
  "_id": "ObjectId",
  "email": "user@example.com",
  "password_hash": "bcrypt_hash",
  "name": "John Doe",
  "phone": "+1234567890",
  "verified": false,
  "verification_token": "uuid",
  "created_at": "2024-01-01T00:00:00Z",
  "updated_at": "2024-01-01T00:00:00Z"
}
Instruments Collection (gotune_instruments.instruments)
json{
  "_id": "ObjectId",
  "name": "Fender Stratocaster",
  "description": "Classic electric guitar",
  "price": 1299.99,
  "category": "Electric Guitars",
  "brand": "Fender",
  "stock_quantity": 5,
  "images": ["url1.jpg", "url2.jpg"],
  "specifications": {
    "color": "Sunburst",
    "material": "Alder",
    "pickup_type": "Single Coil"
  },
  "created_at": "2024-01-01T00:00:00Z",
  "updated_at": "2024-01-01T00:00:00Z"
}
Cart Collection (gotune_cart.carts)
json{
  "_id": "ObjectId",
  "user_id": "ObjectId",
  "items": [
    {
      "instrument_id": "ObjectId",
      "quantity": 2,
      "price": 1299.99,
      "added_at": "2024-01-01T00:00:00Z"
    }
  ],
  "total_amount": 2599.98,
  "created_at": "2024-01-01T00:00:00Z",
  "updated_at": "2024-01-01T00:00:00Z"
}
Orders Collection (gotune_order.orders)
json{
  "_id": "ObjectId",
  "user_id": "ObjectId",
  "order_number": "ORD-2024-001",
  "items": [
    {
      "instrument_id": "ObjectId",
      "instrument_name": "Fender Stratocaster",
      "quantity": 1,
      "unit_price": 1299.99,
      "total_price": 1299.99
    }
  ],
  "total_amount": 1299.99,
  "status": "pending|confirmed|shipped|delivered|cancelled",
  "shipping_address": {
    "street": "123 Main St",
    "city": "New York",
    "state": "NY",
    "zip_code": "10001",
    "country": "USA"
  },
  "created_at": "2024-01-01T00:00:00Z",
  "updated_at": "2024-01-01T00:00:00Z"
}
</details>
<details>
<summary><b>⚡ Redis Cache Keys</b></summary>
User Service Cache

user:profile:{user_id} - User profile data (TTL: 1 hour)
user:session:{session_token} - Active user sessions (TTL: 24 hours)
user:verification:{email} - Email verification tokens (TTL: 1 hour)

Instrument Service Cache

instrument:details:{instrument_id} - Instrument information (TTL: 6 hours)
instrument:list:page:{page} - Paginated instrument lists (TTL: 30 minutes)
instrument:search:{query} - Search results cache (TTL: 15 minutes)

Cart Service Cache

cart:user:{user_id} - User shopping cart (TTL: 7 days)
cart:temp:{session_id} - Anonymous cart data (TTL: 2 hours)

Order Service Cache

order:user:{user_id} - User order history (TTL: 2 hours)
order:details:{order_id} - Order information (TTL: 1 hour)

</details>

🚀 Deployment
<details>
<summary><b>🐳 Docker Production Deployment</b></summary>
bash# 1. Build production images
docker-compose -f docker-compose.prod.yml build

# 2. Start production stack
docker-compose -f docker-compose.prod.yml up -d

# 3. Apply database migrations
docker-compose -f docker-compose.prod.yml exec users go run migrations/runner.go
docker-compose -f docker-compose.prod.yml exec cart go run migrations/runner.go
docker-compose -f docker-compose.prod.yml exec instruments go run migrations/runner.go
docker-compose -f docker-compose.prod.yml exec order go run migrations/runner.go

# 4. Verify deployment
docker-compose -f docker-compose.prod.yml ps
curl http://localhost:8081/users
</details>
<details>
<summary><b>☸️ Kubernetes Deployment</b></summary>
bash# 1. Create namespace
kubectl create namespace gotune

# 2. Apply configuration
kubectl apply -f k8s/configmaps/ -n gotune
kubectl apply -f k8s/secrets/ -n gotune

# 3. Deploy databases
kubectl apply -f k8s/mongodb/ -n gotune
kubectl apply -f k8s/redis/ -n gotune
kubectl apply -f k8s/rabbitmq/ -n gotune

# 4. Deploy microservices
kubectl apply -f k8s/services/ -n gotune

# 5. Deploy API Gateway
kubectl apply -f k8s/api-gateway/ -n gotune

# 6. Verify deployment
kubectl get pods -n gotune
kubectl get services -n gotune
</details>

🤝 Contributing
We welcome contributions from the community! Please follow our contribution guidelines.
<details>
<summary><b>🔄 Development Workflow</b></summary>
Getting Started

Fork the repository on GitHub
Clone your fork locally
Create a feature branch (git checkout -b feature/amazing-feature)
Make your changes following our coding standards
Test your changes thoroughly
Commit your changes (git commit -m 'Add amazing feature')
Push to your branch (git push origin feature/amazing-feature)
Submit a Pull Request

Coding Standards

Follow Go best practices and idioms
Write comprehensive unit tests (minimum 80% coverage)
Use meaningful variable and function names
Add godoc comments for public functions
Run gofmt and golint before committing

Testing Requirements

All new features must include unit tests
Integration tests for API endpoints
Performance tests for critical paths
Update documentation for API changes

</details>

👥 Our Team
<div align="center">
<table>
<tr>
<td align="center" width="25%">
<img src="https://github.com/rishatz.png" width="100px" style="border-radius: 50%"><br>
<b>Rishat Nurassyl</b><br>
<sub>🔧 Backend Developer</sub><br>
<sub>Microservices Architecture</sub><br>
<a href="https://github.com/rishatz">🐙 GitHub</a>
</td>
<td align="center" width="25%">
<img src="https://github.com/myrzanmyrzakhan.png" width="100px" style="border-radius: 50%"><br>
<b>Myrzan Myrzakhan</b><br>
<sub>🔧 Backend Developer</sub><br>
<sub>Database Design & API</sub><br>
<a href="https://github.com/myrzanmyrzakhan">🐙 GitHub</a>
</td>
<td align="center" width="25%">
<img src="https://github.com/berikzayniddinov.png" width="100px" style="border-radius: 50%"><br>
<b>Berik Zayniddinov</b><br>
<sub>👨‍💼 Project Lead</sub><br>
<sub>System Architecture</sub><br>
<a href="https://github.com/berikzayniddinov">🐙 GitHub</a>
</td>
<td align="center" width="25%">
<img src="https://github.com/adilbaltabay.png" width="100px" style="border-radius: 50%"><br>
<b>Adil Baltabay</b><br>
<sub>🔧 Backend Developer</sub><br>
<sub>DevOps & Monitoring</sub><br>
<a href="https://github.com/adilbaltabay">🐙 GitHub</a>
</td>
</tr>
</table>
</div>

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

<div align="center">
🎵 Made with ❤️ and lots of ☕
Go Tune - Where Music Meets Technology
Show Image
Show Image
Show Image
⬆️ Back to Top
</div>