
/**
 * StoreCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v14  Built on : Jul 25, 2015 (11:19:54 IST)
 */

    package fr.alma.domaine.services.impl;

    /**
     *  StoreCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class StoreCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public StoreCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public StoreCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for placeOrder method
            * override this method for handling normal response from placeOrder operation
            */
           public void receiveResultplaceOrder(
                    fr.alma.domaine.services.impl.StoreStub.PlaceOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from placeOrder operation
           */
            public void receiveErrorplaceOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for articles method
            * override this method for handling normal response from articles operation
            */
           public void receiveResultarticles(
                    fr.alma.domaine.services.impl.StoreStub.ArticlesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from articles operation
           */
            public void receiveErrorarticles(java.lang.Exception e) {
            }
                


    }
    