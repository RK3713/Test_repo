//package com.template.contracts;
//
//import com.template.states.TemplateState;
//import net.corda.core.contracts.UniqueIdentifier;
//import net.corda.core.identity.CordaX500Name;
//import net.corda.testing.core.TestIdentity;
//
//import static net.corda.testing.node.NodeTestUtils.ledger;
//
//public class ContractTestUtils {
//
//    TestIdentity dealer = new TestIdentity(new CordaX500Name("Dealer",  "TestLand",  "US"));
//    TestIdentity dmv = new TestIdentity(new CordaX500Name("DMV",  "TestLand",  "US"));
//
//    protected Vehicle vehicle = new Vehicle(new UniqueIdentifier(), "A1234", "2020", "BMW","good","Sedan",dealer.getParty());
//    protected Vehicle vehicleUpdated = new Vehicle(new UniqueIdentifier(), "A1234", "2020", "BMW","bad","Sedan",dealer.getParty());
//
//}
