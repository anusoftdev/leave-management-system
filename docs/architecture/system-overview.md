# System Overview

## Application
Leave Management System is a backend service for managing employee leave requests.

## Core Capabilities
- Employee applies for leave
- Employee views leave requests
- Manager approves or rejects requests

## Architecture
- REST API using Spring Boot
- PostgreSQL database
- Layered architecture:
    - Controller
    - Service
    - Repository
    - Entity / DTO

## Future Platform Capabilities
This project will later include:
- CI pipeline
- Security scans
- Docker image build
- Kubernetes deployment
- Helm packaging
- GitOps via Argo CD
- Infrastructure as Code using Terraform
- Observability via Prometheus and Grafana