
/**
 * BankCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v14  Built on : Jul 25, 2015 (11:19:54 IST)
 */

    package fr.alma.bank;

    /**
     *  BankCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BankCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BankCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BankCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for payment method
            * override this method for handling normal response from payment operation
            */
           public void receiveResultpayment(
                    fr.alma.bank.BankStub.PaymentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from payment operation
           */
            public void receiveErrorpayment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for currencyConvertor method
            * override this method for handling normal response from currencyConvertor operation
            */
           public void receiveResultcurrencyConvertor(
                    fr.alma.bank.BankStub.CurrencyConvertorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from currencyConvertor operation
           */
            public void receiveErrorcurrencyConvertor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hasEnoughMoney method
            * override this method for handling normal response from hasEnoughMoney operation
            */
           public void receiveResulthasEnoughMoney(
                    fr.alma.bank.BankStub.HasEnoughMoneyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hasEnoughMoney operation
           */
            public void receiveErrorhasEnoughMoney(java.lang.Exception e) {
            }
                


    }
    