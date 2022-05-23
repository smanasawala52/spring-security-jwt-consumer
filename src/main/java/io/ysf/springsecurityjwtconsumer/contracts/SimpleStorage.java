package io.ysf.springsecurityjwtconsumer.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
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
public class SimpleStorage extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_ADDPERSON = "addPerson";

    public static final String FUNC_MULTIPLY = "multiply";

    public static final String FUNC_RETRIVE = "retrive";

    public static final String FUNC_RETRIVEALLPEOPLE = "retriveAllPeople";

    public static final String FUNC_RETRIVEPERSON = "retrivePerson";

    public static final String FUNC_STORE = "store";

    @Deprecated
    protected SimpleStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SimpleStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SimpleStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SimpleStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addPerson(BigInteger _favNum, String _name) {
        final Function function = new Function(
                FUNC_ADDPERSON, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_favNum), 
                new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> multiply(BigInteger _favoriteUInt1, BigInteger _favoriteUInt2) {
        final Function function = new Function(FUNC_MULTIPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_favoriteUInt1), 
                new org.web3j.abi.datatypes.generated.Uint256(_favoriteUInt2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> retrive() {
        final Function function = new Function(FUNC_RETRIVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> retriveAllPeople() {
        final Function function = new Function(FUNC_RETRIVEALLPEOPLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Person>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Person> retrivePerson(BigInteger _favNum) {
        final Function function = new Function(FUNC_RETRIVEPERSON, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_favNum)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Person>() {}));
        return executeRemoteCallSingleValueReturn(function, Person.class);
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger _favoriteUInt) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_favoriteUInt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SimpleStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SimpleStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SimpleStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SimpleStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class Person extends DynamicStruct {
        public BigInteger favoriteNumber;

        public String name;

        public Person(BigInteger favoriteNumber, String name) {
            super(new org.web3j.abi.datatypes.generated.Uint256(favoriteNumber),new org.web3j.abi.datatypes.Utf8String(name));
            this.favoriteNumber = favoriteNumber;
            this.name = name;
        }

        public Person(Uint256 favoriteNumber, Utf8String name) {
            super(favoriteNumber,name);
            this.favoriteNumber = favoriteNumber.getValue();
            this.name = name.getValue();
        }
    }
}
