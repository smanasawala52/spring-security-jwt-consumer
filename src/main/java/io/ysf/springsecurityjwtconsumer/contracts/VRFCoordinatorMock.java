package io.ysf.springsecurityjwtconsumer.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class VRFCoordinatorMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516104d23803806104d283398101604081905261002f91610054565b600080546001600160a01b0319166001600160a01b0392909216919091179055610082565b600060208284031215610065578081fd5b81516001600160a01b038116811461007b578182fd5b9392505050565b610441806100916000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80631b6b6d2314610046578063a4c0ed3614610064578063cf55fe9714610079575b600080fd5b61004e61008c565b60405161005b919061037d565b60405180910390f35b610077610072366004610222565b61009b565b005b610077610087366004610302565b610128565b6000546001600160a01b031681565b6000546001600160a01b031633146100ce5760405162461bcd60e51b81526004016100c5906103c8565b60405180910390fd5b600080828060200190518101906100e591906102df565b915091508082866001600160a01b03167f7a9a0a6960d95b32cded93c30e63e7c2eb9e877230813c172110ea54dc1c915c60405160405180910390a45050505050565b6000806394985ddd60e01b858560405160240161014692919061036f565b60408051601f198184030181529190526020810180516001600160e01b03166001600160e01b0319909316929092179091529050620324b0805a101561019e5760405162461bcd60e51b81526004016100c590610391565b6000846001600160a01b0316836040516101b89190610336565b6000604051808303816000865af19150503d80600081146101f5576040519150601f19603f3d011682016040523d82523d6000602084013e6101fa565b606091505b50505050505050505050565b80356001600160a01b038116811461021d57600080fd5b919050565b600080600060608486031215610236578283fd5b61023f84610206565b92506020808501359250604085013567ffffffffffffffff80821115610263578384fd5b818701915087601f830112610276578384fd5b813581811115610288576102886103f5565b604051601f8201601f19168101850183811182821017156102ab576102ab6103f5565b60405281815283820185018a10156102c1578586fd5b81858501868301378585838301015280955050505050509250925092565b600080604083850312156102f1578182fd5b505080516020909101519092909150565b600080600060608486031215610316578283fd5b833592506020840135915061032d60408501610206565b90509250925092565b60008251815b81811015610356576020818601810151858301520161033c565b818111156103645782828501525b509190910192915050565b918252602082015260400190565b6001600160a01b0391909116815260200190565b6020808252601b908201527f6e6f7420656e6f7567682067617320666f7220636f6e73756d65720000000000604082015260600190565b60208082526013908201527226bab9ba103ab9b2902624a725903a37b5b2b760691b604082015260600190565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220e8c8a3f3a357bfcbaf427a44b736f1162ccde432ee47cf652e52a1713556ee0664736f6c63430008000033";

    public static final String FUNC_LINK = "LINK";

    public static final String FUNC_CALLBACKWITHRANDOMNESS = "callBackWithRandomness";

    public static final String FUNC_ONTOKENTRANSFER = "onTokenTransfer";

    public static final Event RANDOMNESSREQUEST_EVENT = new Event("RandomnessRequest", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<RandomnessRequestEventResponse> getRandomnessRequestEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RANDOMNESSREQUEST_EVENT, transactionReceipt);
        ArrayList<RandomnessRequestEventResponse> responses = new ArrayList<RandomnessRequestEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RandomnessRequestEventResponse typedResponse = new RandomnessRequestEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.keyHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.seed = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RandomnessRequestEventResponse> randomnessRequestEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RandomnessRequestEventResponse>() {
            @Override
            public RandomnessRequestEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RANDOMNESSREQUEST_EVENT, log);
                RandomnessRequestEventResponse typedResponse = new RandomnessRequestEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.keyHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.seed = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RandomnessRequestEventResponse> randomnessRequestEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RANDOMNESSREQUEST_EVENT));
        return randomnessRequestEventFlowable(filter);
    }

    public RemoteFunctionCall<String> LINK() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LINK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> callBackWithRandomness(byte[] requestId, BigInteger randomness, String consumerContract) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLBACKWITHRANDOMNESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(randomness), 
                new org.web3j.abi.datatypes.Address(consumerContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onTokenTransfer(String sender, BigInteger fee, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONTOKENTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sender), 
                new org.web3j.abi.datatypes.generated.Uint256(fee), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class RandomnessRequestEventResponse extends BaseEventResponse {
        public String sender;

        public byte[] keyHash;

        public BigInteger seed;
    }
}
