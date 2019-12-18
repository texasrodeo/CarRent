package persestance.old;

import domain.Contract;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ContractStore {
    private AtomicLong currentId = new AtomicLong();

    public AtomicLong getCurrentId(){
        return currentId;
    }

    private static ContractStore instance;

    public static ContractStore getInstance(){
        if(instance == null) {
            instance = new ContractStore();
        }
        return instance;
    }

    private List<Contract> contracts = new ArrayList<>();

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setCars(List<Contract> contracts) {
        this.contracts = contracts;
    }



    public boolean addContract(Contract contract){
        return this.contracts.add(contract);
    }

    public boolean removeContract(Contract  contract){
        return contracts.remove(contract);
    }

    public List<Contract> getApprovedContracts(){
        List<Contract> approvedContracts = new ArrayList<>();
        for(Contract contract: contracts){
            if(contract.getIsApproved())
                approvedContracts.add(contract);
        }
        return approvedContracts;
    }

    public List<Contract> getNotApprovedContracts(){
        List<Contract> approvedContracts = new ArrayList<>();
        for(Contract contract: contracts){
            if(!contract.getIsApproved())
                approvedContracts.add(contract);
        }
        return approvedContracts;
    }

    public List<Contract> getNotApprovedContractsForClient(User client){
        List<Contract> result = new ArrayList<>();
//        for(Contract contract: contracts){
//            if(!contract.getIsApproved() && contract.getClient().equals(client))
//                result.add(contract);
//        }
        return result;
    }

    public List<Contract> getApprovedContractsForClient(User client){
        List<Contract> result = new ArrayList<>();
//        for(Contract contract: contracts){
//            if(contract.getIsApproved() && contract.getClient().equals(client))
//                result.add(contract);
//        }
        return result;
    }

    public boolean approveContract(Contract contract, User admin){
        for(Contract contract1: contracts){
//            if(contract1.equals(contract)){
//                contract1.setIsApproved(true, admin);
//                contract1.getCar().setIsAvailable(false);
//                return true;
//            }
        }
        return false;
    }

    public ContractStore(){

    }
}
