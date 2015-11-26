
/**
 * SupplierCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v14  Built on : Jul 25, 2015 (11:19:54 IST)
 */

    package supplier;

    /**
     *  SupplierCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SupplierCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SupplierCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SupplierCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getItemsList method
            * override this method for handling normal response from getItemsList operation
            */
           public void receiveResultgetItemsList(
                    supplier.SupplierStub.GetItemsListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemsList operation
           */
            public void receiveErrorgetItemsList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItemsNames method
            * override this method for handling normal response from getItemsNames operation
            */
           public void receiveResultgetItemsNames(
                    supplier.SupplierStub.GetItemsNamesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemsNames operation
           */
            public void receiveErrorgetItemsNames(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItemById method
            * override this method for handling normal response from getItemById operation
            */
           public void receiveResultgetItemById(
                    supplier.SupplierStub.GetItemByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemById operation
           */
            public void receiveErrorgetItemById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for placeOrder method
            * override this method for handling normal response from placeOrder operation
            */
           public void receiveResultplaceOrder(
                    supplier.SupplierStub.PlaceOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from placeOrder operation
           */
            public void receiveErrorplaceOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItemsCount method
            * override this method for handling normal response from getItemsCount operation
            */
           public void receiveResultgetItemsCount(
                    supplier.SupplierStub.GetItemsCountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemsCount operation
           */
            public void receiveErrorgetItemsCount(java.lang.Exception e) {
            }
                


    }
    