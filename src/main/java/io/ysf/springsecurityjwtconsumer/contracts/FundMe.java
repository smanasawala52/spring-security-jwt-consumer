package io.ysf.springsecurityjwtconsumer.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class FundMe extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516108d13803806108d183398101604081905261002f91610062565b60028054336001600160a01b031991821617909155600080549091166001600160a01b0392909216919091179055610092565b60006020828403121561007457600080fd5b81516001600160a01b038116811461008b57600080fd5b9392505050565b610830806100a16000396000f3fe60806040526004361061009c5760003560e01c8063741bef1a11610064578063741bef1a146101645780638395a7441461019c5780638da5cb5b146101bc57806398d5fdca146101dc578063b60d4288146101f1578063dc0d3dff146101f957600080fd5b806309bc33a7146100a15780633c7e7d28146100c95780633ccfd60b146100f65780634ec5e4331461010057806360e3949f14610118575b600080fd5b3480156100ad57600080fd5b506100b6610219565b6040519081526020015b60405180910390f35b3480156100d557600080fd5b506100b66100e43660046106ab565b60016020526000908152604090205481565b6100fe610256565b005b34801561010c57600080fd5b50644d67a791886100b6565b34801561012457600080fd5b5061012d610360565b6040805169ffffffffffffffffffff968716815260208101959095528401929092526060830152909116608082015260a0016100c0565b34801561017057600080fd5b50600054610184906001600160a01b031681565b6040516001600160a01b0390911681526020016100c0565b3480156101a857600080fd5b506100b66101b73660046106d4565b6103fa565b3480156101c857600080fd5b50600254610184906001600160a01b031681565b3480156101e857600080fd5b506100b661043f565b6100fe6104b8565b34801561020557600080fd5b506101846102143660046106d4565b610607565b60006802b5e3af16b18800008161022e61043f565b9050670de0b6b3a7640000816102448285610703565b61024e9190610722565b935050505090565b6002546001600160a01b031633146102b55760405162461bcd60e51b815260206004820152601e60248201527f4f6e6c792061646d696e2063616e2077697468647261772066756e647321000060448201526064015b60405180910390fd5b60405133904780156108fc02916000818181858888f193505050501580156102e1573d6000803e3d6000fd5b5060005b60035481101561033f576000600160006003848154811061030857610308610744565b60009182526020808320909101546001600160a01b03168352820192909252604001902055806103378161075a565b9150506102e5565b50604080516000815260208101918290525161035d91600391610631565b50565b60008060008060008060008060008060008054906101000a90046001600160a01b03166001600160a01b031663feaf968c6040518163ffffffff1660e01b815260040160a060405180830381865afa1580156103c0573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103e49190610792565b939e929d50909b50995090975095505050505050565b60008061040b83633b9aca00610703565b61041990633b9aca00610703565b610427906305f5e100610703565b9050610438644d67a7918882610722565b9392505050565b6000805460408051633fabe5a360e21b8152905183926001600160a01b03169163feaf968c9160048083019260a09291908290030181865afa158015610489573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104ad9190610792565b509195945050505050565b600254336001600160a01b03909116036105145760405162461bcd60e51b815260206004820152601d60248201527f4f6e6c79206e6f6e2061646d696e2063616e2066756e6420746869732100000060448201526064016102ac565b3460326000610522826103fa565b90506000610534633b9aca0083610722565b90508184101561059b5760405162461bcd60e51b815260206004820152602c60248201527f596f75206e65656420746f207370656e64206d6f726520455448202d206d696e60448201526b696d756d203530205553442160a01b60648201526084016102ac565b33600090815260016020526040812080548692906105ba9084906107e2565b9091555050600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b0180546001600160a01b0319163317905550505050565b6003818154811061061757600080fd5b6000918252602090912001546001600160a01b0316905081565b828054828255906000526020600020908101928215610686579160200282015b8281111561068657825182546001600160a01b0319166001600160a01b03909116178255602090920191600190910190610651565b50610692929150610696565b5090565b5b808211156106925760008155600101610697565b6000602082840312156106bd57600080fd5b81356001600160a01b038116811461043857600080fd5b6000602082840312156106e657600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b600081600019048311821515161561071d5761071d6106ed565b500290565b60008261073f57634e487b7160e01b600052601260045260246000fd5b500490565b634e487b7160e01b600052603260045260246000fd5b60006001820161076c5761076c6106ed565b5060010190565b805169ffffffffffffffffffff8116811461078d57600080fd5b919050565b600080600080600060a086880312156107aa57600080fd5b6107b386610773565b94506020860151935060408601519250606086015191506107d660808701610773565b90509295509295909350565b600082198211156107f5576107f56106ed565b50019056fea26469706673582212207f37324f1ec2c27d7a8fa58459ec4aff70b23dc7f624b8e2c66dcd06bb2b9b2e64736f6c634300080d0033";

    public static final String FUNC_ADDRESSTOAMOUNT = "addressToAmount";

    public static final String FUNC_FUND = "fund";

    public static final String FUNC_FUNDERS = "funders";

    public static final String FUNC_GETCONVERSIONUSDTOWEI = "getConversionUSDToWEI";

    public static final String FUNC_GETENTRANCEFEE = "getEntranceFee";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_GETPRICEALL = "getPriceAll";

    public static final String FUNC_GETPRICEHARDCODE = "getPriceHardCode";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PRICEFEED = "priceFeed";

    public static final String FUNC_WITHDRAW = "withdraw";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected FundMe(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FundMe(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FundMe(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FundMe(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> addressToAmount(String param0) {
        final Function function = new Function(FUNC_ADDRESSTOAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> fund(BigInteger bigInteger) {
        final Function function = new Function(
                FUNC_FUND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function,bigInteger);
    }

    public RemoteFunctionCall<String> funders(BigInteger param0) {
        final Function function = new Function(FUNC_FUNDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getConversionUSDToWEI(BigInteger inputAmtUSD) {
        final Function function = new Function(FUNC_GETCONVERSIONUSDTOWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(inputAmtUSD)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEntranceFee() {
        final Function function = new Function(FUNC_GETENTRANCEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPrice() {
        final Function function = new Function(FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getPriceAll() {
        final Function function = new Function(FUNC_GETPRICEALL, 
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

    public RemoteFunctionCall<BigInteger> getPriceHardCode() {
        final Function function = new Function(FUNC_GETPRICEHARDCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> priceFeed() {
        final Function function = new Function(FUNC_PRICEFEED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static FundMe load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundMe(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FundMe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundMe(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FundMe load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new FundMe(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FundMe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new FundMe(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<FundMe> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _priceFeedAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress)));
        return deployRemoteCall(FundMe.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<FundMe> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _priceFeedAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress)));
        return deployRemoteCall(FundMe.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundMe> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _priceFeedAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress)));
        return deployRemoteCall(FundMe.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundMe> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _priceFeedAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress)));
        return deployRemoteCall(FundMe.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
