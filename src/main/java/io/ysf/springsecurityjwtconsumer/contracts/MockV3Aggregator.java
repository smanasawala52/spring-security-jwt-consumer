package io.ysf.springsecurityjwtconsumer.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class MockV3Aggregator extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516105ad3803806105ad83398101604081905261002f916100a4565b6000805460ff191660ff84161790556100478161004e565b50506100fd565b60018190554260025560038054906000610067836100d6565b9091555050600380546000908152600460209081526040808320949094558254825260058152838220429081905592548252600690529190912055565b600080604083850312156100b6578182fd5b825160ff811681146100c6578283fd5b6020939093015192949293505050565b60006000198214156100f657634e487b7160e01b81526011600452602481fd5b5060010190565b6104a18061010c6000396000f3fe608060405234801561001057600080fd5b50600436106100b45760003560e01c80638205bf6a116100715780638205bf6a146101265780639a6fc8f51461012e578063a87a20ce14610152578063b5ab58dc14610165578063b633620c14610178578063feaf968c1461018b576100b4565b8063313ce567146100b95780634aa2011f146100d757806350d25bcd146100ec57806354fd4d5014610101578063668a0f02146101095780637284e41614610111575b600080fd5b6100c1610193565b6040516100ce9190610436565b60405180910390f35b6100ea6100e536600461036f565b61019c565b005b6100f46101e9565b6040516100ce91906103a7565b6100f46101ef565b6100f46101f4565b6101196101fa565b6040516100ce91906103b0565b6100f4610231565b61014161013c36600461034e565b610237565b6040516100ce959493929190610403565b6100ea610160366004610336565b610270565b6100f4610173366004610336565b6102c6565b6100f4610186366004610336565b6102d8565b6101416102ea565b60005460ff1681565b69ffffffffffffffffffff90931660038181556001849055600283905560009182526004602090815260408084209590955581548352600581528483209390935554815260069091522055565b60015481565b600081565b60035481565b60408051808201909152601f81527f76302e362f74657374732f4d6f636b563341676772656761746f722e736f6c00602082015290565b60025481565b69ffffffffffffffffffff8116600090815260046020908152604080832054600683528184205460059093529220549293919290918490565b6001819055426002556003805490600061028983610444565b9091555050600380546000908152600460209081526040808320949094558254825260058152838220429081905592548252600690529190912055565b60046020526000908152604090205481565b60056020526000908152604090205481565b60035460008181526004602090815260408083205460068352818420546005909352922054839091929394565b803569ffffffffffffffffffff8116811461033157600080fd5b919050565b600060208284031215610347578081fd5b5035919050565b60006020828403121561035f578081fd5b61036882610317565b9392505050565b60008060008060808587031215610384578283fd5b61038d85610317565b966020860135965060408601359560600135945092505050565b90815260200190565b6000602080835283518082850152825b818110156103dc578581018301518582016040015282016103c0565b818111156103ed5783604083870101525b50601f01601f1916929092016040019392505050565b69ffffffffffffffffffff9586168152602081019490945260408401929092526060830152909116608082015260a00190565b60ff91909116815260200190565b600060001982141561046457634e487b7160e01b81526011600452602481fd5b506001019056fea26469706673582212201e506ec537a466634b82e97f19f7acf0a66a8a4a3124e37112b60bee79ff220264736f6c63430008000033";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_GETANSWER = "getAnswer";

    public static final String FUNC_GETROUNDDATA = "getRoundData";

    public static final String FUNC_GETTIMESTAMP = "getTimestamp";

    public static final String FUNC_LATESTANSWER = "latestAnswer";

    public static final String FUNC_LATESTROUND = "latestRound";

    public static final String FUNC_LATESTROUNDDATA = "latestRoundData";

    public static final String FUNC_LATESTTIMESTAMP = "latestTimestamp";

    public static final String FUNC_UPDATEANSWER = "updateAnswer";

    public static final String FUNC_UPDATEROUNDDATA = "updateRoundData";

    public static final String FUNC_VERSION = "version";

    public static final Event ANSWERUPDATED_EVENT = new Event("AnswerUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWROUND_EVENT = new Event("NewRound", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MockV3Aggregator(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MockV3Aggregator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MockV3Aggregator(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MockV3Aggregator(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AnswerUpdatedEventResponse> getAnswerUpdatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ANSWERUPDATED_EVENT, transactionReceipt);
        ArrayList<AnswerUpdatedEventResponse> responses = new ArrayList<AnswerUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AnswerUpdatedEventResponse>() {
            @Override
            public AnswerUpdatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ANSWERUPDATED_EVENT, log);
                AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
                typedResponse.log = log;
                typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ANSWERUPDATED_EVENT));
        return answerUpdatedEventFlowable(filter);
    }

    public List<NewRoundEventResponse> getNewRoundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWROUND_EVENT, transactionReceipt);
        ArrayList<NewRoundEventResponse> responses = new ArrayList<NewRoundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewRoundEventResponse typedResponse = new NewRoundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewRoundEventResponse>() {
            @Override
            public NewRoundEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWROUND_EVENT, log);
                NewRoundEventResponse typedResponse = new NewRoundEventResponse();
                typedResponse.log = log;
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWROUND_EVENT));
        return newRoundEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> description() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAnswer(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getRoundData(BigInteger _roundId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint80(_roundId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getTimestamp(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestAnswer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTANSWER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestRound() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> latestRoundData() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUNDDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> latestTimestamp() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateAnswer(BigInteger _answer) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_answer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateRoundData(BigInteger _roundId, BigInteger _answer, BigInteger _timestamp, BigInteger _startedAt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint80(_roundId), 
                new org.web3j.abi.datatypes.generated.Int256(_answer), 
                new org.web3j.abi.datatypes.generated.Uint256(_timestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_startedAt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MockV3Aggregator load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockV3Aggregator(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MockV3Aggregator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockV3Aggregator(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MockV3Aggregator load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MockV3Aggregator(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MockV3Aggregator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MockV3Aggregator(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AnswerUpdatedEventResponse extends BaseEventResponse {
        public BigInteger current;

        public BigInteger roundId;

        public BigInteger updatedAt;
    }

    public static class NewRoundEventResponse extends BaseEventResponse {
        public BigInteger roundId;

        public String startedBy;

        public BigInteger startedAt;
    }
}
