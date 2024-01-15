# EventTrackerProject

## Description
This tracker was created to track stories and tales that encompass American folklore.

## Tech Used
JPACRUDProject
Description
Tech Used
| HTTP Verb | URI               | Request Body | Response Body | Status Codes |
|-----------|-------------------|--------------|---------------|---------|
| GET       | `/api/folklore`      |              | List of all _folklore_ entities | 200 |
| GET       | `/api/folklore/1`   |              | JSON of _foklore_ `1` | 200, 404 |
| POST      | `/api/folklore`      | JSON of a new _folklore_ entity  | JSON of created _folklore_ | 201,400 |
| PUT       | `/api/folklore/1`   | JSON of a new version of _folklore_ `1` | JSON of updated _folklore_ | 200,404,400 |
| DELETE    | `/api/folklore/1`   |              |               | 204,404,400|



## Lessons Learned
Before looking into your code to try and resolve issues with controllers or even after checking your code, double check and make sure there are no unecessary capitilizations in the mapping. 