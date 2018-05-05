# Sample Project
It is sample java project with maven dependency injection

## Archiecture
This project is structured into several logical layers:
- **Customer model** that describes data
- **Customer repository** stores customers data and provides access to it
- **Customer service** provide business logical service
- **Application class** utilizes service

## Design

However, it doesn't use any dependency injection, so it lacks:
- Tightly coupled classes
- Not testable
- Not reusable as with hard configuration
- Too much extra work, other than actual business logic

