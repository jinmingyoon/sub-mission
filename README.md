# Preview

```
backend
 ㄴ springboot + jpa 사용
 ㄴ 본 개발내용은 springboot, jpa을 사용하여 Frontend에 데이터를 전달할 API 서버
 ㄴ DB는 postgresql로 연동했으며 controller, dto, entity, repository, service 구현

front
 ㄴ React 활용 화면 구현

```

# Environment

```
backend
- springboot
- jap
- gradle
- postgresql

front
- React
```

# 프로젝트 파일 구조

```
backend
 common/
  ㄴ 공통 관련 exception, swagger
 food/
  ㄴ API 기능 관련 controller, dto, entity, repository, service

front
 pages/
  - 화면을 구성하는 컴포넌트
    helper/
    - 화면 필요한 스타일, 타입스크립트 작성시 필요한 인터페이스
    service/
    - rest api 통신을 위한 axio
```

# swagger-ui

```
http://localhost:8080/swagger-ui.html
```
