package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import product.Product;

import database.product.ProductTable;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAdd.class,
        TestDelete.class,
        TestUpdate.class,
        TestCheckout.class
})

public class TestProductTable {

}





