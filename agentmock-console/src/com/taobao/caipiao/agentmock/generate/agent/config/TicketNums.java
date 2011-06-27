/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class TicketNums.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TicketNums implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ticketNumList.
     */
    private java.util.Vector<java.lang.String> _ticketNumList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TicketNums() {
        super();
        this._ticketNumList = new java.util.Vector<java.lang.String>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTicketNum
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTicketNum(
            final java.lang.String vTicketNum)
    throws java.lang.IndexOutOfBoundsException {
        this._ticketNumList.addElement(vTicketNum);
    }

    /**
     * 
     * 
     * @param index
     * @param vTicketNum
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTicketNum(
            final int index,
            final java.lang.String vTicketNum)
    throws java.lang.IndexOutOfBoundsException {
        this._ticketNumList.add(index, vTicketNum);
    }

    /**
     * Method enumerateTicketNum.
     * 
     * @return an Enumeration over all java.lang.String elements
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateTicketNum(
    ) {
        return this._ticketNumList.elements();
    }

    /**
     * Method getTicketNum.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getTicketNum(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ticketNumList.size()) {
            throw new IndexOutOfBoundsException("getTicketNum: Index value '" + index + "' not in range [0.." + (this._ticketNumList.size() - 1) + "]");
        }

        return (java.lang.String) _ticketNumList.get(index);
    }

    /**
     * Method getTicketNum.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getTicketNum(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._ticketNumList.toArray(array);
    }

    /**
     * Method getTicketNumCount.
     * 
     * @return the size of this collection
     */
    public int getTicketNumCount(
    ) {
        return this._ticketNumList.size();
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
    public void removeAllTicketNum(
    ) {
        this._ticketNumList.clear();
    }

    /**
     * Method removeTicketNum.
     * 
     * @param vTicketNum
     * @return true if the object was removed from the collection.
     */
    public boolean removeTicketNum(
            final java.lang.String vTicketNum) {
        boolean removed = _ticketNumList.remove(vTicketNum);
        return removed;
    }

    /**
     * Method removeTicketNumAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeTicketNumAt(
            final int index) {
        java.lang.Object obj = this._ticketNumList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vTicketNum
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTicketNum(
            final int index,
            final java.lang.String vTicketNum)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ticketNumList.size()) {
            throw new IndexOutOfBoundsException("setTicketNum: Index value '" + index + "' not in range [0.." + (this._ticketNumList.size() - 1) + "]");
        }

        this._ticketNumList.set(index, vTicketNum);
    }

    /**
     * 
     * 
     * @param vTicketNumArray
     */
    public void setTicketNum(
            final java.lang.String[] vTicketNumArray) {
        //-- copy array
        _ticketNumList.clear();

        for (int i = 0; i < vTicketNumArray.length; i++) {
                this._ticketNumList.add(vTicketNumArray[i]);
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
     * com.taobao.caipiao.agentmock.generate.agent.config.TicketNums
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.TicketNums unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.TicketNums) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.TicketNums.class, reader);
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
