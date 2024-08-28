
# Wide Technologies Technical Test

My submission for Spring Boot Developer position at WideTechnologies




## Run Project

To run this project, go to folder `place-order2`

```bash
  cd place-order2
```

The project run at 8082:

```bash
  http://localhost:8082/
```

## API Reference

#### GET Products
get all avaliable products

```http
  GET /api/products?page=0&size=10
```

#### POST products to the list
add new product to the product list

```http
  POST /api/products/
```

#### GET Cart
get all product on the cart

```http
  GET /api/cart
```

#### POST Cart to the cart list
add product to the cart

```http
  POST /api/cart/add?productId=${productId}&quantity=${quantity}
```

#### POST Order
Finalize order on the cart list

```http
  POST /cart/place
```


