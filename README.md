# HW
### 目錄結構
```
HardwareProject
├─controller
│  ├─member
│      AddMemberErrorUI.java
│      AddMemberSuccessUI.java
│      AddMemberUI.java
│      LoginErrorUI.java
│      LoginSuccessUI.java
│      LoginUI.java
│  ├─mlist
│      AddPorderCart.java
│      AddPorderCheckout.java
│      AddPorderUI.java
├─dao
│  │─MemberDao.java
│  ├─PorderDao.java
│  └─impl
│      MemberDaoImpl.java
│      PorderDaoImpl.java
├─model
│    │─Member.java
│    │─Porder .java
├─service
│  │─MemberService.java
│  │─PorderService.java
│  └─impl
│      MemberServiceImpl.java
│      PorderServiceImpl.java
└─util
   │─ChangeCalculator
   │─Clock
   │─PrintUtility
   │─DbConnection.java
   │─Tool.java
```
### 測試環境
- #### 資料庫環境：
請安裝 MySQL（使用[ MySQL Community Server](https://dev.mysql.com/downloads/mysql/ "游標顯示") (下載8.0版本)），並匯入提供的 SQL 腳本建立所需的資料表。
