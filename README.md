# Leave Management System

A sample enterprise-style Spring Boot application used to learn and implement a full end-to-end CI/CD pipeline.

## Tech Stack
- Java 17
- Spring Boot 3
- Maven
- PostgreSQL
- Docker
- GitHub Actions
- SonarQube
- Trivy
- Kubernetes
- Helm
- Argo CD
- Terraform
- Prometheus / Grafana

## Current Features
- Apply leave
- View leave requests
- Approve leave
- Reject leave

## Project Structure
- `app/` → Spring Boot application
- `infra/` → Kubernetes, Helm, Terraform, Argo CD
- `.github/workflows/` → CI/CD pipelines
- `docs/` → architecture, runbooks, release notes

## Local Run
1. Start PostgreSQL
2. Run app from `app/`
3. Open Swagger UI

## Learning Goal
This repository is being built as a full enterprise-grade CI/CD learning project from scratch.