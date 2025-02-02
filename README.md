# Schedule

## 필수 과제

### API

#### Schedules

| **Method** | **Endpoint**         | **Description**                     | **Parameters**                                                                            | **Request Body**                                                                                                 | **Response**                                                                                                                                     | **Status Code** |
|------------|----------------------|-------------------------------------|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|
| `POST`     | `/schedules`         | 일정 생성                           | 없음                                                                                        | `{ "task": string, "password": string, "memberName": string }`                                                   | `{ "id": long, "task": string, "password": string, "memberName": string, "createdAt": string, "updatedAt": string }`                              | `200 OK`        |
| `GET`      | `/schedules`         | 일정 목록 조회      | Query: <br> - `updatedDate` (예: "2025-02-02", `optional`)<br> - `memberName` (`optional`) | 없음                                                                                                             | `[ { "id": long, "task": string, "password": string, "memberName": string, "createdAt": string, "updatedAt": string }, ... ]`                      | `200 OK`        |
| `GET`      | `/schedules/{id}`    | 일정 단건 조회                | Path: <br> - `id`                                                                         | 없음                                                                                                             | `{ "id": long, "task": string, "password": string, "memberName": string, "createdAt": string, "updatedAt": string }`                               | `200 OK`        |
| `PUT`      | `/schedules/{id}`    | 일정 수정                     | Path: <br> - `id`                                                                         | `{ "task": string, "password": string, "memberName": string }`                                                   | `{ "id": long, "task": string, "password": string, "memberName": string, "createdAt": string, "updatedAt": string }`                               | `200 OK`        |
| `DELETE`   | `/schedules/{id}`    | 일정 삭제          | Path: <br> - `id` <br> Query: <br> - `password` (`mandatory`)                              | 없음                                                                                                             | 없음                                                                                                                                             | `200 OK`        |

### SQL

```sql
CREATE TABLE schedule (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      task VARCHAR(255) NOT NULL,
      password VARCHAR(255) NOT NULL,
      member_name VARCHAR(255) NOT NULL,
      created_at DATETIME NOT NULL,
      updated_at DATETIME NOT NULL
)
```

### ERD

![erd_mandatory](./images/erd_mandatory.png)

> `?` 표시가 없는 경우 `NOT NULL` 입니다. (ex. `DATETIME?` 일 경우 nullable 필드) 
