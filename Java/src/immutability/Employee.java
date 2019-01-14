package immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Sample Employee Immutable Class
 * Created by wajahat
 *
 * This is immutable class the following are the steps
 * 1) Class is final so that no other class can derive from it
 * 2) All the fields of the class are final so that they cannot be instantiated more than once
 * 3) There is no setter method exposed to modify the state of the members of its class
 * 4) When exposing the methods which modify the state always return a new instance of the class
 * 5) If a class holds mutable object:
 *      i) Inside the constructor make sure to clone the object and deep copy all the values of this class and assign the new reference
 *      ii) Make sure to always return the cloned object and never return the real object reference
 */
public final class Employee {
    private final String name;
    private final Address address;
    private final Age age;

    List<Integer> list;

    // perform the deep copy
    public Employee(String name, Address address, List<Integer> list, Age age) {
        this.name = name;
        this.address = new Address(address.getCity());
        List<Integer> l = new ArrayList<>(list.size());
        l.addAll(list);
        this.list = l;
        this.age = new Age(age.getDay(), age.getMonth(), age.getYear());
    }

    public String getName() { return  name; }
    public Address getAddress() {
        return new Address(address.getCity());
    }
    public List<Integer> getList() { return  new ArrayList<>(list); }

    public Age getAge() { return new Age(age.getDay(), age.getMonth(), age.getYear()); }
}
