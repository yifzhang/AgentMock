/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Tickets.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Tickets implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ticketList.
     */
    private java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Ticket> _ticketList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Tickets() {
        super();
        this._ticketList = new java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Ticket>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTicket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTicket(
            final com.taobao.caipiao.agentmock.generate.agent.config.Ticket vTicket)
    throws java.lang.IndexOutOfBoundsException {
        this._ticketList.addElement(vTicket);
    }

    /**
     * 
     * 
     * @param index
     * @param vTicket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTicket(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Ticket vTicket)
    throws java.lang.IndexOutOfBoundsException {
        this._ticketList.add(index, vTicket);
    }

    /**
     * Method enumerateTicket.
     * 
     * @return an Enumeration over all
     * com.taobao.caipiao.agentmock.generate.agent.config.Ticket
     * elements
     */
    public java.util.Enumeration<? extends com.taobao.caipiao.agentmock.generate.agent.config.Ticket> enumerateTicket(
    ) {
        return this._ticketList.elements();
    }

    /**
     * Method getTicket.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.taobao.caipiao.agentmock.generate.agent.config.Ticket at
     * the given index
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Ticket getTicket(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ticketList.size()) {
            throw new IndexOutOfBoundsException("getTicket: Index value '" + index + "' not in range [0.." + (this._ticketList.size() - 1) + "]");
        }

        return (com.taobao.caipiao.agentmock.generate.agent.config.Ticket) _ticketList.get(index);
    }

    /**
     * Method getTicket.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Ticket[] getTicket(
    ) {
        com.taobao.caipiao.agentmock.generate.agent.config.Ticket[] array = new com.taobao.caipiao.agentmock.generate.agent.config.Ticket[0];
        return (com.taobao.caipiao.agentmock.generate.agent.config.Ticket[]) this._ticketList.toArray(array);
    }

    /**
     * Method getTicketCount.
     * 
     * @return the size of this collection
     */
    public int getTicketCount(
    ) {
        return this._ticketList.size();
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
    public void removeAllTicket(
    ) {
        this._ticketList.clear();
    }

    /**
     * Method removeTicket.
     * 
     * @param vTicket
     * @return true if the object was removed from the collection.
     */
    public boolean removeTicket(
            final com.taobao.caipiao.agentmock.generate.agent.config.Ticket vTicket) {
        boolean removed = _ticketList.remove(vTicket);
        return removed;
    }

    /**
     * Method removeTicketAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Ticket removeTicketAt(
            final int index) {
        java.lang.Object obj = this._ticketList.remove(index);
        return (com.taobao.caipiao.agentmock.generate.agent.config.Ticket) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vTicket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTicket(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Ticket vTicket)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ticketList.size()) {
            throw new IndexOutOfBoundsException("setTicket: Index value '" + index + "' not in range [0.." + (this._ticketList.size() - 1) + "]");
        }

        this._ticketList.set(index, vTicket);
    }

    /**
     * 
     * 
     * @param vTicketArray
     */
    public void setTicket(
            final com.taobao.caipiao.agentmock.generate.agent.config.Ticket[] vTicketArray) {
        //-- copy array
        _ticketList.clear();

        for (int i = 0; i < vTicketArray.length; i++) {
                this._ticketList.add(vTicketArray[i]);
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
     * com.taobao.caipiao.agentmock.generate.agent.config.Tickets
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Tickets unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Tickets) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Tickets.class, reader);
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
