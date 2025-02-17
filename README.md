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
│  ├─porder
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

- #### JDK環境：
#### 下載並安裝[JDK 11](https://www.oracle.com/java/technologies/downloads/#java11?er=221886 "游標顯示")環境。  
在 CMD 中執行下列命令以確認安裝版本。
```plaintext
<javac -version>
```
```plaintext
<java -version>
```
### 下載連結  
[sql資料庫,jar執行檔](https://github.com/ren857/HW/tree/main/%E4%BD%9C%E6%A5%AD2 "游標顯示")

### 實作說明:  
- #### 登入畫面 (LoginUI.java)
 
<img src="https://github.com/user-attachments/assets/e70e4e2c-68dd-423b-ba80-5994da8e7249" alt="示例圖像" width="500" height="500">

- #### 登入成功畫面(LoginSuccessUI.java)

<img src="https://github.com/user-attachments/assets/e69ecb80-0b48-498d-9943-0c2985dc07bf" alt="示例圖像" width="500" height="500">

- #### 購物畫面(AddPorderUI.java)

<img src="https://github.com/user-attachments/assets/d82146f8-f189-4385-960c-9c4b04ee12c3" alt="示例圖像" width="500" height="500">  

- #### 購物車畫面(AddPorderCart.java)

<img src="https://github.com/user-attachments/assets/be2b6526-420d-4f77-8a2a-97635cd90a8c" alt="示例圖像" width="500" height="500">

- #### 結帳畫面(AddPorderCheckout.java)

<img src="https://github.com/user-attachments/assets/e03403fe-ab9c-4963-b5a3-5baf0f6802e2" alt="示例圖像" width="500" height="500">
 




