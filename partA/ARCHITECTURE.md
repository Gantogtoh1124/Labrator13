# System Architecture

## 🧱 Architecture Type
Layered Architecture

## 📊 Diagram

```mermaid
graph TD
Client --> API[Express API]
API --> Controller[Controllers]
Controller --> Service[Services]
Service --> DB[(SQLite Database)]