package com.fssa.shopnow.validator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.shopnow.errors.ShopErrors;
import com.fssa.shopnow.model.Shop;
import com.fssa.shopnow.exception.InvalidShopException;

public class TestShopValidator {
    // Sample data for creating a Shop instance
    int id = 1;
    String name = "SRI SAI MOBILES";
    String image = "https://lh5.googleusercontent.com/p/AF1QipOi7r9XakmIbf7cHIVtMu-Km-K0-xeRhud9RQaS=w390-h262-n-k-no";
    String address = "No#4, MGR Salai, Tharamani, Chennai, Tamil Nadu";
    String area = "tharamani";
    double lat = 12.978622;
    double lon = 80.243273;
    String phoneNumber = "6374523897";
    String pincode = "614810";
    int sellerId = 2;
    String license = "2384uojflkls";

    // Create a Shop instance for testing
    Shop shop = new Shop(id, name, image, address, area, lat, lon, phoneNumber, pincode, sellerId, license);

    // Test case to validate the Shop object
    @Test
    public void testShopObject() {
        // Assert that the Shop object is valid
        Assertions.assertTrue(ValidateShop.validate(shop));

        try {
            // Attempt to validate a null Shop object, expecting an InvalidShopException
            ValidateShop.validate(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.NULL_OBJECT, e.getMessage());
        }
    }

    // Test case for validating Shop ID
    @Test
    public void testId() {
        // Assert that the Shop ID is valid
        Assertions.assertTrue(ValidateShop.isValidId(id));

        try {
            // Attempt to validate an invalid Shop ID (less than 1), expecting an InvalidShopException
            ValidateShop.isValidId(-4);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_ID, e.getMessage());
        }
    }

    // Test case for validating Shop name
    @Test
    public void testName() {
        // Assert that the Shop name is valid
        Assertions.assertTrue(ValidateShop.isValidName(name));

        try {
            // Attempt to validate a null Shop name, expecting an InvalidShopException
            ValidateShop.isValidName(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.NULL_NAME, e.getMessage());
        }
    }
    
 // Test case for validating Shop image URL
    @Test
    public void testImage() {
        // Assert that the Shop image URL is valid
        Assertions.assertTrue(ValidateShop.isValidImageURL(image));

        try {
            // Attempt to validate a null Shop image URL, expecting an InvalidShopException
            ValidateShop.isValidImageURL(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_IMAGEURL, e.getMessage());
        }
    }

    // Test case for validating Shop address
    @Test
    public void testAddress() {
        // Assert that the Shop address is valid
        Assertions.assertTrue(ValidateShop.isValidAddress(address));

        try {
            // Attempt to validate a null Shop address, expecting an InvalidShopException
            ValidateShop.isValidAddress(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.NULL_ADDRESS, e.getMessage());
        }
    }

    // Test case for validating Shop area
    @Test
    public void testArea() {
        // Assert that the Shop area is valid
        Assertions.assertTrue(ValidateShop.isValidArea(area));

        try {
            // Attempt to validate a null Shop area, expecting an InvalidShopException
            ValidateShop.isValidArea(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_AREA, e.getMessage());
        }
    }

    // Test case for validating Shop latitude
    @Test
    public void testLatitude() {
        // Assert that the Shop latitude is valid
        Assertions.assertTrue(ValidateShop.isValidLatitude(lat));

        try {
            // Attempt to validate an invalid Shop latitude (less than -90), expecting an InvalidShopException
            ValidateShop.isValidLatitude(-100);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_LAT, e.getMessage());
        }
    }

    // Test case for validating Shop longitude
    @Test
    public void testLongitude() {
        // Assert that the Shop longitude is valid
        Assertions.assertTrue(ValidateShop.isValidLongtitude(lon));

        try {
            // Attempt to validate an invalid Shop longitude (less than -180), expecting an InvalidShopException
            ValidateShop.isValidLongtitude(-190);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_LON, e.getMessage());
        }
    }

    // Test case for validating Shop phone number
    @Test
    public void testPhoneNumber() {
        // Assert that the Shop phone number is valid
        Assertions.assertTrue(ValidateShop.isValidMobileNumber(phoneNumber));

        try {
            // Attempt to validate a null Shop phone number, expecting an InvalidShopException
            ValidateShop.isValidMobileNumber(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.NULL_MOBILE_NUMBER, e.getMessage());
        }
    }

    // Test case for validating Shop pincode
    @Test
    public void testPincode() {
        // Assert that the Shop pincode is valid
        Assertions.assertTrue(ValidateShop.isValidPincode(pincode));

        try {
            // Attempt to validate a null Shop pincode, expecting an InvalidShopException
            ValidateShop.isValidPincode(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.EMPTY_PINCODE, e.getMessage());
        }
    }

    // Test case for validating Shop seller ID
    @Test
    public void testSellerId() {
        // Assert that the Shop seller ID is valid
        Assertions.assertTrue(ValidateShop.isValidId(sellerId));

        try {
            // Attempt to validate an invalid Shop seller ID (less than 1), expecting an InvalidShopException
            ValidateShop.isValidId(-4);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.INVALID_ID, e.getMessage());
        }
    }

    // Test case for validating Shop license
    @Test
    public void testLicense() {
        // Assert that the Shop license is valid
        Assertions.assertTrue(ValidateShop.isValidLicense(license));

        try {
            // Attempt to validate a null Shop license, expecting an InvalidShopException
            ValidateShop.isValidLicense(null);
            Assertions.fail(ShopErrors.EXPECTED_FAIL);
        } catch (InvalidShopException e) {
            // Ensure that the correct error message is received
            Assertions.assertEquals(ShopErrors.NULL_LICENSE, e.getMessage());
        }
    }		
}
