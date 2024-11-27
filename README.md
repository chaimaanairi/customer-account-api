# Customer Account API with Frontend

This project provides an API to manage customer accounts along with a simple frontend for interacting with the API. It allows you to create new accounts for existing customers, manage account balances, and display customer information.

## Features
- **Backend (API)**:
  - Create a new "current account" for an existing customer.
  - Optionally, deposit an initial credit when creating the account.
  - View customer information (name, surname, balance, and transaction history).

- **Frontend**:
  - Simple web interface to interact with the API.
  - Allows the user to create accounts and view customer information.

## Project Structure
- **Backend (API)**:
  - Located in the `AccountApi` directory.
  - Built using Spring Boot and Java.
  - Exposes endpoints to create accounts and view customer data.

- **Frontend**:
  - Located in the `account-frontend` directory.
  - Simple frontend built using HTML, CSS, and JavaScript.
  - Makes API requests to the backend to create accounts and fetch customer data.

- **CI/CD**:
  - A GitHub Actions workflow is set up to automatically build and deploy the project.

## Requirements

- **Backend**:
  - Java 19 (or later)
  - Maven for building and running the project
  - Spring Boot 3.x

- **Frontend**:
  - A modern browser (Chrome, Firefox, etc.)

## Installation

### Backend (API)
1. Clone the repository:
   ```bash
   git clone https://github.com/chaimaanairi/customer-account-api.git
   cd customer-account-api
