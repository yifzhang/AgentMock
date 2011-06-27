/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.lotteryagent.config;

/**
 * Class LotteryAgentApp.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LotteryAgentApp implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lotteryAgentList.
     */
    private java.util.Vector<com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent> _lotteryAgentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LotteryAgentApp() {
        super();
        this._lotteryAgentList = new java.util.Vector<com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLotteryAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLotteryAgent(
            final com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent vLotteryAgent)
    throws java.lang.IndexOutOfBoundsException {
        this._lotteryAgentList.addElement(vLotteryAgent);
    }

    /**
     * 
     * 
     * @param index
     * @param vLotteryAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLotteryAgent(
            final int index,
            final com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent vLotteryAgent)
    throws java.lang.IndexOutOfBoundsException {
        this._lotteryAgentList.add(index, vLotteryAgent);
    }

    /**
     * Method enumerateLotteryAgent.
     * 
     * @return an Enumeration over all
     * com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent
     * elements
     */
    public java.util.Enumeration<? extends com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent> enumerateLotteryAgent(
    ) {
        return this._lotteryAgentList.elements();
    }

    /**
     * Method getLotteryAgent.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent
     * at the given index
     */
    public com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent getLotteryAgent(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lotteryAgentList.size()) {
            throw new IndexOutOfBoundsException("getLotteryAgent: Index value '" + index + "' not in range [0.." + (this._lotteryAgentList.size() - 1) + "]");
        }

        return (com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent) _lotteryAgentList.get(index);
    }

    /**
     * Method getLotteryAgent.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent[] getLotteryAgent(
    ) {
        com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent[] array = new com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent[0];
        return (com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent[]) this._lotteryAgentList.toArray(array);
    }

    /**
     * Method getLotteryAgentCount.
     * 
     * @return the size of this collection
     */
    public int getLotteryAgentCount(
    ) {
        return this._lotteryAgentList.size();
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllLotteryAgent(
    ) {
        this._lotteryAgentList.clear();
    }

    /**
     * Method removeLotteryAgent.
     * 
     * @param vLotteryAgent
     * @return true if the object was removed from the collection.
     */
    public boolean removeLotteryAgent(
            final com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent vLotteryAgent) {
        boolean removed = _lotteryAgentList.remove(vLotteryAgent);
        return removed;
    }

    /**
     * Method removeLotteryAgentAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent removeLotteryAgentAt(
            final int index) {
        java.lang.Object obj = this._lotteryAgentList.remove(index);
        return (com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vLotteryAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLotteryAgent(
            final int index,
            final com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent vLotteryAgent)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lotteryAgentList.size()) {
            throw new IndexOutOfBoundsException("setLotteryAgent: Index value '" + index + "' not in range [0.." + (this._lotteryAgentList.size() - 1) + "]");
        }

        this._lotteryAgentList.set(index, vLotteryAgent);
    }

    /**
     * 
     * 
     * @param vLotteryAgentArray
     */
    public void setLotteryAgent(
            final com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent[] vLotteryAgentArray) {
        //-- copy array
        _lotteryAgentList.clear();

        for (int i = 0; i < vLotteryAgentArray.length; i++) {
                this._lotteryAgentList.add(vLotteryAgentArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgentApp
     */
    public static com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgentApp unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgentApp) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgentApp.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
