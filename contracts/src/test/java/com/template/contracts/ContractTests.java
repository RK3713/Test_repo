//package com.template.contracts;
//
//import com.template.states.TemplateState;
//import net.corda.core.contracts.UniqueIdentifier;
//import com.template.contracts.ContractTestUtils;
//import net.corda.testing.node.MockServices;
//import org.junit.Test;
//import net.corda.testing.contracts.DummyState;
//import java.util.Arrays;
//
//import static net.corda.testing.node.NodeTestUtils.ledger;
//
//public class ContractTests extends ContractTestUtils {
//
//    @Test
//    public void OnlyOneOutput() {
//        final MockServices ledgerServices = new MockServices(Arrays.asList("com.template"));
//        //TemplateState state = new TemplateState(new UniqueIdentifier(),dealer.getParty(),dmv.getParty(),);
//        ledger(ledgerServices, l -> {
//            l.transaction(tx -> {
//                tx.input(VehicleContract.ID, new DummyState());
//                tx.output(VehicleContract.ID, vehicle);
//                tx.command(dealer.getPublicKey(), new VehicleContract.Commands.Create());
//                return tx.fails(); //fails because of having inputs
//            });
//            l.transaction(tx -> {
//                tx.output(VehicleContract.ID, vehicle);
//               tx.command(dealer.getPublicKey(), new VehicleContract.Commands.Create());
//                return tx.verifies();
//            });
//            return null;
//        });
//    }
//
//
//
//}
