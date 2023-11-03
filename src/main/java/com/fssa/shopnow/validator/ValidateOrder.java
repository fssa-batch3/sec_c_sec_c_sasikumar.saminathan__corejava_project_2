package com.fssa.shopnow.validator;

import java.time.LocalDate;

import com.fssa.shopnow.errors.AddressErrors;
import com.fssa.shopnow.errors.OrderErrors;
import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.exception.InvalidOrderException;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.model.Order;

public class ValidateOrder {

	  private ValidateOrder() {
		  throw new IllegalStateException("Utility class");
	}
	  
	  public static boolean isValidObj(Order order) throws InvalidOrderException {

			// Check the nullity of the object
			if (order == null) {
				throw new InvalidOrderException(OrderErrors.NULL_OBJ);
			}
			 
			//Validate the all attributes 
			isvalidUserId(order.getUserId());
			isvalidShopId(order.getShopId());
			isvalidAddressId(order.getAddressId());
			isvalidProductId(order.getProductId());
			isValidDate(order.getDate());
			isValidQty(order.getQuantity());
			isValidStatus(order.getStatus());
			

			return true;
		}
	  
		//Validate the AddressId
		public static boolean isvalidAddressId(int id) throws InvalidOrderException{
			if(id < 0) {
				throw new InvalidOrderException(OrderErrors.INVALID_ADDRESS_ID);
			}
			return true;
		}
		
		//Validate the user id
		public static boolean isvalidUserId(int id) throws InvalidOrderException{
			if(id < 0) {
				throw new InvalidOrderException(OrderErrors.INVALID_USER_ID);
			}
			return true;
		}
		
		//Validate the shop id
		public static boolean isvalidShopId(int id) throws InvalidOrderException{
			if(id < 0) {
				throw new InvalidOrderException(OrderErrors.INVALID_SHOP_ID);
			}
			return true;
		}
		
		//Validate the product id
		public static boolean isvalidProductId(int id) throws InvalidOrderException{
			if(id < 0) {
				throw new InvalidOrderException(OrderErrors.INVALID_PRODUCT_ID);
			}
			return true;
		}
		
		//Validate the AddressId
		public static boolean isValidQty(int quantity) throws InvalidOrderException{
			if(quantity <= 0) {
				throw new InvalidOrderException(OrderErrors.INVALID_QUANTITY);
			}
			return true;
		}
		
		//Validate the status of the order
		public static boolean isValidStatus(String status) throws InvalidOrderException{
			if(status == null) {
				throw new InvalidOrderException(OrderErrors.INVALID_STATUS);
			}
			if(!(status.equals("In-transit") || status.equals("Delivered") || status.equals("Canceled"))) {
				throw new InvalidOrderException(OrderErrors.INVALID_STATUS);
			}
			return true;
		}
		
		//Validate the ordered date
		public static boolean isValidDate(LocalDate date) throws InvalidOrderException{
			LocalDate currentDate = LocalDate.now();
			if(date == null || date.isBefore(currentDate)) {
				throw new InvalidOrderException(OrderErrors.INVALID_DATE);
			}
			return true;
		}
		
		//Validate the payment method
		public static boolean isValidPaymentMethod(String payment) throws InvalidOrderException{
			
			if(payment == null){
				throw new InvalidOrderException(OrderErrors.INVALID_PAYMENT_METHOD);
			}
			
			if(!(payment.equals("UPI") || payment.equals("Credit/Debit/Atm card") || payment.equals("No cost EMI") || payment.equals("Cash on delivery"))) {
				throw new InvalidOrderException(OrderErrors.INVALID_PAYMENT_METHOD);
			}
			return true;
		}
}
