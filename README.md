# letspdf

![File-Format-PDF-256](https://user-images.githubusercontent.com/42717485/175357856-99f2d010-87df-4a78-8308-9abd83d1ff9f.png)

Image to PDF conversion service

### Features
  - Converts Image(s) to PDF file instantly
  - Friendly User Interface

### How to run using Docker

```
docker run -it -p 8080:8080 -v <path-to-repo>\letspdf\letspdf-server\src\main\resources:/files --name letspdf-server letspdf-server:1.0.0
```
