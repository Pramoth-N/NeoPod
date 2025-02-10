Here is the question:  

---

### **Emma’s Product and Order Analysis using Numeric Functions**  

Emma is a data analyst at an e-commerce company, and she needs to analyze various aspects of the product inventory and orders to provide insights for the management team. She has been asked to use numeric functions to extract specific information from the `PRODUCTS` and `ORDERS` tables.  

---

### **Table Details**  

#### **PRODUCTS Table**
| COLUMN NAME  | DATA TYPE |
|-------------|----------|
| PRODUCT_ID  | INT      |
| PRODUCT_NAME | VARCHAR |
| PRICE       | DECIMAL  |
| STOCK       | INT      |

#### **ORDERS Table**
| COLUMN NAME  | DATA TYPE |
|-------------|----------|
| ORDER_ID    | INT      |
| PRODUCT_ID  | INT      |
| QUANTITY    | INT      |
| TOTAL_PRICE | DECIMAL  |

---

### **Tasks**  

Write SQL queries to extract the following insights:  

1. **Stock Difference Calculation:**  
   - Calculate the absolute difference between the stock of each product and **200 units**.  
   - Use the alias name **STOCK_DIFFERENCE**.  
   - Display it along with **PRODUCT_NAME** from the `PRODUCTS` table.  

2. **Rounded-Down Price:**  
   - Get the **rounded-down price** value for each product.  
   - Use the alias name **NEW_PRICE**.  
   - Display it along with **PRODUCT_NAME** from the `PRODUCTS` table.  

3. **Rounded-Up Price:**  
   - Get the **rounded-up price** value for each product.  
   - Use the alias name **NEW_PRICE**.  
   - Display it along with **PRODUCT_NAME** from the `PRODUCTS` table.  

4. **Price Remainder Calculation:**  
   - Determine the remainder when the **TOTAL_PRICE** of each order is divided by **100**.  
   - Use the alias name **PRICE_REMAINDER**.  
   - Display it along with **ORDER_ID** and **PRODUCT_ID** from the `ORDERS` table.  

5. **Quantity Squared:**  
   - Calculate the **square of the QUANTITY ordered** for each order.  
   - Use the alias name **QUANTITY_SQUARED**.  
   - Display it along with **ORDER_ID** and **PRODUCT_ID** from the `ORDERS` table.  

6. **Rounded Total Price:**  
   - Round the **TOTAL_PRICE** of each order to the nearest whole number.  
   - Use the alias name **ROUNDED_TOTAL_PRICE**.  
   - Display it along with **ORDER_ID** and **PRODUCT_ID** from the `ORDERS` table.  

---

### **Input Format**  
- The tables `PRODUCTS` and `ORDERS` are **already created and prepopulated**.  
- You **only need to write SQL queries** to extract the required results.  

### **Output Format**  
- The queries should return the requested values in tabular format.  

---

### **Sample Output**  

#### **Stock Difference Calculation**
| PRODUCT_NAME | STOCK_DIFFERENCE |
|-------------|-----------------|
| Headphones  | 100             |
| Speaker     | 50              |
| Monitor     | 80              |
| Keyboard    | 300             |
| Mouse       | 400             |

#### **Rounded-Down Price**
| PRODUCT_NAME | NEW_PRICE |
|-------------|----------|
| Headphones  | 149      |
| Speaker     | 99       |
| Monitor     | 249      |
| Keyboard    | 49       |
| Mouse       | 29       |

#### **Rounded-Up Price**
| PRODUCT_NAME | NEW_PRICE |
|-------------|----------|
| Headphones  | 150      |
| Speaker     | 100      |
| Monitor     | 250      |
| Keyboard    | 50       |
| Mouse       | 30       |

#### **Price Remainder Calculation**
| ORDER_ID | PRODUCT_ID | PRICE_REMAINDER |
|---------|-----------|----------------|
| 1       | 1         | 99.98          |
| 2       | 2         | 99.99          |
| 3       | 3         | 49.97          |
| 4       | 4         | 49.95          |
| 5       | 5         | 29.99          |

#### **Quantity Squared**
| ORDER_ID | PRODUCT_ID | QUANTITY_SQUARED |
|---------|-----------|-----------------|
| 1       | 1         | 4               |
| 2       | 2         | 1               |
| 3       | 3         | 9               |
| 4       | 4         | 25              |
| 5       | 5         | 1               |

#### **Rounded Total Price**
| ORDER_ID | PRODUCT_ID | ROUNDED_TOTAL_PRICE |
|---------|-----------|--------------------|
| 1       | 1         | 200                |
| 2       | 2         | 100                |
| 3       | 3         | 750                |
| 4       | 4         | 250                |
| 5       | 5         | 30                 |

---

---

This question tests your ability to apply **numeric functions** (`ABS()`, `FLOOR()`, `CEIL()`, `MOD()`, `POWER()`, `ROUND()`) in SQL effectively. 🚀

Here are the SQL queries to extract the required data using numeric functions:  

```sql
-- 1. Calculate the absolute difference between stock and 200
SELECT PRODUCT_NAME, ABS(STOCK - 200) AS STOCK_DIFFERENCE 
FROM PRODUCTS;

-- 2. Get the rounded-down price value
SELECT PRODUCT_NAME, FLOOR(PRICE) AS NEW_PRICE 
FROM PRODUCTS;

-- 3. Get the rounded-up price value
SELECT PRODUCT_NAME, CEIL(PRICE) AS NEW_PRICE 
FROM PRODUCTS;

-- 4. Determine the remainder when total price is divided by 100
SELECT ORDER_ID, PRODUCT_ID, MOD(TOTAL_PRICE, 100) AS PRICE_REMAINDER 
FROM ORDERS;

-- 5. Calculate the square of the quantity ordered
SELECT ORDER_ID, PRODUCT_ID, POWER(QUANTITY, 2) AS QUANTITY_SQUARED 
FROM ORDERS;

-- 6. Round the total price to the nearest whole number
SELECT ORDER_ID, PRODUCT_ID, ROUND(TOTAL_PRICE) AS ROUNDED_TOTAL_PRICE 
FROM ORDERS;
```

These queries use numeric functions like `ABS()`, `FLOOR()`, `CEIL()`, `MOD()`, `POWER()`, and `ROUND()` to generate the required results. Let me know if you need any modifications! 🚀