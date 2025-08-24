# getAllProfilesForAdmin (GET /api/profiles)

## Description
Development-only endpoint that retrieves all profiles in the system. Requires admin secret key for authentication.

**Note: This endpoint is disabled in production environments.**

## Request

### Query Parameters

| Name        | Type   | Required | Constraint |
|-------------|--------|----------|------------|
| `secretKey` | string | true     | @NotBlank  |

## Reply

### Response Body

| Name             | Type     | Description                          |
|------------------|----------|--------------------------------------|
| `profileId`      | integer  | The unique identifier of the profile |
| `gender`         | string   | Gender of the profile owner          |
| `department`     | string   | Department of the profile owner                           |
| `birthYear`      | integer  | Birth year of the profile owner                           |
| `animal`         | string   | Animal representing the profile      |
| `mbti`           | string   | MBTI personality type                |
| `nickname`       | string   | Profile's nickname                   |
| `introSentences` | string[] | Empty List                           |

### 200 OK

```json
{
  "timestamp": "2025-04-27T14:40:54.486393+09:00",
  "result": [
    {
      "profileId": 1,
      "gender": "FEMALE",
      "department": "학과",
      "birthYear": 2000,
      "animal": "DOG",
      "mbti": "ISTJ",
      "nickname": "leopold",
      "introSentences": []
    },
    {
      "profileId": 2,
      "gender": "FEMALE",
      "department": "학과",
      "birthYear": 2000,
      "animal": "DOG",
      "mbti": "ISTJ",
      "nickname": "leopold",
      "introSentences": []
    },
    {
      "profileId": 3,
      "gender": "FEMALE",
      "department": "학과",
      "birthYear": 2000,
      "animal": "DOG",
      "mbti": "ISTJ",
      "nickname": "leopold",
      "introSentences": []
    }
  ]
}
```

### 403 Forbidden

When the secret key is invalid.

```json
{
  "timestamp": "2025-04-27T14:41:27.810708+09:00",
  "status": 403,
  "message": "올바르지 않은 관리자 기능 접근 토큰입니다."
}
```

### 404 Not Found (Production Environment)

This endpoint returns 404 in production environments as it is not registered.

```json
{
  "timestamp": "2025-04-27T14:41:27.810708+09:00",
  "status": 404,
  "error": "Not Found",
  "message": "No static resource api/profiles."
}
```
