package io.ysf.springsecurityjwtconsumer.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class FundMe extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516106c13803806106c183398101604081905261002f91610062565b60028054336001600160a01b031991821617909155600080549091166001600160a01b0392909216919091179055610090565b600060208284031215610073578081fd5b81516001600160a01b0381168114610089578182fd5b9392505050565b6106228061009f6000396000f3fe60806040526004361061003f5760003560e01c806309bc33a7146100445780633c7e7d281461006f5780633ccfd60b1461008f578063b60d428814610099575b600080fd5b34801561005057600080fd5b506100596100a1565b604051610066919061055b565b60405180910390f35b34801561007b57600080fd5b5061005961008a366004610424565b6100de565b6100976100f0565b005b6100976101dc565b60006802b5e3af16b1880000816100b66102b5565b9050670de0b6b3a7640000816100cc828561059c565b6100d6919061057c565b935050505090565b60016020526000908152604090205481565b6002546001600160a01b031633146101235760405162461bcd60e51b815260040161011a906104a1565b60405180910390fd5b60405133904780156108fc02916000818181858888f1935050505015801561014f573d6000803e3d6000fd5b5060005b6003548110156101bb576000600160006003848154811061018457634e487b7160e01b600052603260045260246000fd5b60009182526020808320909101546001600160a01b03168352820192909252604001902055806101b3816105bb565b915050610153565b5060408051600081526020810191829052516101d991600391610390565b50565b6002546001600160a01b03163314156102075760405162461bcd60e51b815260040161011a90610524565b34603260006102158261033d565b90506000610227633b9aca008361057c565b9050818410156102495760405162461bcd60e51b815260040161011a906104d8565b3360009081526001602052604081208054869290610268908490610564565b9091555050600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b0180546001600160a01b0319163317905550505050565b6000805460408051633fabe5a360e21b8152905183926001600160a01b03169163feaf968c9160048083019260a0929190829003018186803b1580156102fa57600080fd5b505afa15801561030e573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103329190610452565b509194505050505090565b60008061034e83633b9aca0061059c565b61035c90633b9aca0061059c565b61036a906305f5e10061059c565b9050610374610387565b61037e908261057c565b9150505b919050565b644d67a7918890565b8280548282559060005260206000209081019282156103e5579160200282015b828111156103e557825182546001600160a01b0319166001600160a01b039091161782556020909201916001909101906103b0565b506103f19291506103f5565b5090565b5b808211156103f157600081556001016103f6565b805169ffffffffffffffffffff8116811461038257600080fd5b600060208284031215610435578081fd5b81356001600160a01b038116811461044b578182fd5b9392505050565b600080600080600060a08688031215610469578081fd5b6104728661040a565b94506020860151935060408601519250606086015191506104956080870161040a565b90509295509295909350565b6020808252601e908201527f4f6e6c792061646d696e2063616e2077697468647261772066756e6473210000604082015260600190565b6020808252602c908201527f596f75206e65656420746f207370656e64206d6f726520455448202d206d696e60408201526b696d756d203530205553442160a01b606082015260800190565b6020808252601d908201527f4f6e6c79206e6f6e2061646d696e2063616e2066756e64207468697321000000604082015260600190565b90815260200190565b60008219821115610577576105776105d6565b500190565b60008261059757634e487b7160e01b81526012600452602481fd5b500490565b60008160001904831182151516156105b6576105b66105d6565b500290565b60006000198214156105cf576105cf6105d6565b5060010190565b634e487b7160e01b600052601160045260246000fdfea2646970667358221220aadf67fa70e22e25b0da568deef97f2b618d2cf271f056ab0d0dbda1e174677964736f6c63430008000033";

    public static final String FUNC_ADDRESSTOAMOUNT = "addressToAmount";

    public static final String FUNC_FUND = "fund";

    public static final String FUNC_GETENTRANCEFEE = "getEntranceFee";

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

    public RemoteFunctionCall<TransactionReceipt> fund() {
        final Function function = new Function(
                FUNC_FUND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getEntranceFee() {
        final Function function = new Function(FUNC_GETENTRANCEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
