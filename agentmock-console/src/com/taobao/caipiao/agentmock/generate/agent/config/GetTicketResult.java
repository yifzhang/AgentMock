/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class GetTicketResult.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class GetTicketResult implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sync.
     */
    private java.lang.String _sync;

    /**
     * Field _resultCode.
     */
    private java.lang.String _resultCode;

    /**
     * Field _maxTicketNum.
     */
    private java.lang.String _maxTicketNum;

    /**
     * Field _ticketNums.
     */
    private com.taobao.caipiao.agentmock.generate.agent.config.TicketNums _ticketNums;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetTicketResult() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'maxTicketNum'.
     * 
     * @return the value of field 'MaxTicketNum'.
     */
    public java.lang.String getMaxTicketNum(
    ) {
        return this._maxTicketNum;
    }

    /**
     * Returns the value of field 'resultCode'.
     * 
     * @return the value of field 'ResultCode'.
     */
    public java.lang.String getResultCode(
    ) {
        return this._resultCode;
    }

    /**
     * Returns the value of field 'sync'.
     * 
     * @return the value of field 'Sync'.
     */
    public java.lang.String getSync(
    ) {
        return this._sync;
    }

    /**
     * Returns the value of field 'ticketNums'.
     * 
     * @return the value of field 'TicketNums'.
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.TicketNums getTicketNums(
    ) {
        return this._ticketNums;
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
     * Sets the value of field 'maxTicketNum'.
     * 
     * @param maxTicketNum the value of field 'maxTicketNum'.
     */
    public void setMaxTicketNum(
            final java.lang.String maxTicketNum) {
        this._maxTicketNum = maxTicketNum;
    }

    /**
     * Sets the value of field 'resultCode'.
     * 
     * @param resultCode the value of field 'resultCode'.
     */
    public void setResultCode(
            final java.lang.String resultCode) {
        this._resultCode = resultCode;
    }

    /**
     * Sets the value of field 'sync'.
     * 
     * @param sync the value of field 'sync'.
     */
    public void setSync(
            final java.lang.String sync) {
        this._sync = sync;
    }

    /**
     * Sets the value of field 'ticketNums'.
     * 
     * @param ticketNums the value of field 'ticketNums'.
     */
    public void setTicketNums(
            final com.taobao.caipiao.agentmock.generate.agent.config.TicketNums ticketNums) {
        this._ticketNums = ticketNums;
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
     * com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult.class, reader);
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
