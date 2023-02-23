## 요구 사항
```PC방 사용자 목록```을 저장할 테이블을 설계한다.
### 필드
  - ```user_index```: 사용자를 구분하는 key 값, <u>null 불가</u>
  - ```pc_start_time```: 사용 시작 시간, <u>null 불가</u>
  - ```pc_end_time``` : 사용 종료 시간, null 가능
  - ```seat_index(PK)``` : pc 자리 번호, <u>null 불가</u> 

## 개발 환경

- MacOS Monterey 12.5.1
- IntelliJ IDEA 2022.2.4 (Community Edition)
- Java version 11.0.16.1
- Docker version 20.10.22
- MySQL version 8.0.32

# IntelliJ JDBC 연동

## 드라이버 추가

- JDBC로 MySQL을 사용하기 위해서는 JDBC 드라이버인 MySQL Connector가 필요하다.
- 아래 링크에서 Platform Independent를 선택해 tar.gz 파일을 다운로드 받는다.
    - [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
- 외부 라이브러리로 다운로드 받은 MySQL Connnector를 추가한다.
    - IntelliJ > File > Project Structure > Library
  <p align="center">
  <img width="1136" alt="MyConnector 라이브러리 추가" src="https://user-images.githubusercontent.com/117690393/220922169-6eb4afcd-7724-4d5c-a7f6-98153a59a581.png">
  〰️ 라이브러리 추가 〰️
  </p>
  <br>
  
  <p align="center">
  <img width="275" alt="라이브러리 적용" src="https://user-images.githubusercontent.com/117690393/220924328-7ff9ebe5-0d06-4885-9876-bded3339149c.png"><br>
  <br>
  〰️ 프로젝트 윈도우의 외부 라이브러리에도 잘 적용된 모습 〰️
  </p>

## MySQL DB 생성

- JDBC에 MySQL을 연동하기 전 테이블을 생성한다.
  <p align="center">
  <img width="900" alt="테이블 생성" src="https://user-images.githubusercontent.com/117690393/220929345-4ef081d3-c49f-4431-8379-7037d727fa31.png"><br>
  〰️ pcbang 테이블 생성 〰️
  </p>
  <br>

  <p align="center">
  <img width="591" alt="image" src="https://user-images.githubusercontent.com/117690393/220938318-cde6689f-8e85-46b7-a49e-1676fdd3dac8.png"><br>
  〰️ 필드 생성 쿼리 〰️
  </p>

```
mysql> USE pcbang;
Database changed
mysql> INSERT INTO pc_table (pc_start_time, pc_end_time, user_index) VALUE(now(), null, 0);
Query OK, 1 row affected (0.03 sec)
```

<p align="center">
〰️ 테스트용 데이터 삽입 〰️
</p>

## JDBC 쿼리 작성 및 확인
### JDBC를 이용한 프로그래밍 방법
1. import java.sql.*;
2. 드라이버를 로드
3. Connection 객체 생성
4. Statement 객체 생성
5. ResultSet 객체를 생성
6. 모든 객체를 닫는다.

```java
package cs15;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pcbang";
        String userName = "pcbang_manager";
        String password = "qwer1234";

        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("db연결성공~~!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from pc_table");

        while (resultSet.next()) {
            String seat_number = resultSet.getString(1);    // columnIndex는 1부터 시작
            System.out.println(seat_number);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

![image](https://user-images.githubusercontent.com/117690393/220973098-127a32bd-8d48-4e11-bbd9-9e9f1dd571c1.png)
<p align="center">
〰️ JDBC 연동 성공 〰️
</p>

> 연동은 성공했지만 Time Zone 설정이 되어 있지 않아 UTC -> KST로 수정 필요

### MySQL Time Zone 변경  // 작성중
ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

SET GLOBAL time_zone='Asia/Seoul';

SET time_zone='Asia/Seoul';

lect @@global.time_zone, @@session.time_zone,@@system_time_zone;

truncate pc_table



Last login: Fri Feb 24 02:58:40 on ttys000
hanawang@Hanaui-MacBookPro ~ % docker exec -it cs15 bash  
bash-4.4# mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 15
Server version: 8.0.32 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> exit
Bye
bash-4.4# ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
bash-4.4# date
Fri Feb 24 03:18:15 KST 2023
bash-4.4# mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 16
Server version: 8.0.32 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> date
-> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'date' at line 1
mysql> SET GLOBAL time_zone='Asia/Seoul';
Query OK, 0 rows affected (0.00 sec)

mysql> SET time_zone='Asia/Seoul';
Query OK, 0 rows affected (0.00 sec)

mysql> lect @@global.time_zone, @@session.time_zone,@@system_time_zone;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'lect @@global.time_zone, @@session.time_zone,@@system_time_zone' at line 1
mysql> select @@global.time_zone, @@session.time_zone,@@system_time_zone;
+--------------------+---------------------+--------------------+
| @@global.time_zone | @@session.time_zone | @@system_time_zone |
+--------------------+---------------------+--------------------+
| Asia/Seoul         | Asia/Seoul          | UTC                |
+--------------------+---------------------+--------------------+
1 row in set (0.00 sec)

mysql> desc pc_table;
ERROR 1046 (3D000): No database selected
mysql> use pc_bang;
ERROR 1049 (42000): Unknown database 'pc_bang'
mysql> use pcbang;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> desc pc_table;
+---------------+------+------+-----+---------+----------------+
| Field         | Type | Null | Key | Default | Extra          |
+---------------+------+------+-----+---------+----------------+
| seat_index    | int  | NO   | PRI | NULL    | auto_increment |
| pc_start_time | time | NO   |     | NULL    |                |
| pc_end_time   | time | YES  |     | NULL    |                |
| user_index    | int  | NO   |     | NULL    |                |
+---------------+------+------+-----+---------+----------------+
4 rows in set (0.01 sec)

mysql> truncate pc_table
-> ;
Query OK, 0 rows affected (0.07 sec)

mysql> insert into pc_table (pc_start_time, pc_end_time, user_index) value(now(), null, 0);
Query OK, 1 row affected (0.02 sec)

mysql>
---
aws linux였다!,,,

## 📑 References
- [Docker를 사용하여 Mysql 컨테이너 생성하고 접속하기](https://tear94fall.tistory.com/6)
- [IntelliJ JDBC 연동(MySQL)](https://velog.io/@woook/IntelliJ-JDBC)
- 
