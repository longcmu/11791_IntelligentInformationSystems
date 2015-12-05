package edu.cmu.deiis.types;

/* First created by JCasGen Mon Sep 29 11:54:27 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;


/** 
 * Updated by JCasGen Thu Oct 02 12:25:08 EDT 2014
 * XML source: /home/ronhe/newworkspace/hw2-longh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class NameTag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NameTag.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NameTag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NameTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NameTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NameTag(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NameTag_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((NameTag_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NameTag_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((NameTag_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: beginPos

  /** getter for beginPos - gets 
   * @generated
   * @return value of the feature 
   */
  public int getBeginPos() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_beginPos == null)
      jcasType.jcas.throwFeatMissing("beginPos", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getIntValue(addr, ((NameTag_Type)jcasType).casFeatCode_beginPos);}
    
  /** setter for beginPos - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBeginPos(int v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_beginPos == null)
      jcasType.jcas.throwFeatMissing("beginPos", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setIntValue(addr, ((NameTag_Type)jcasType).casFeatCode_beginPos, v);}    
   
    
  //*--------------*
  //* Feature: endPos

  /** getter for endPos - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEndPos() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_endPos == null)
      jcasType.jcas.throwFeatMissing("endPos", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getIntValue(addr, ((NameTag_Type)jcasType).casFeatCode_endPos);}
    
  /** setter for endPos - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEndPos(int v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_endPos == null)
      jcasType.jcas.throwFeatMissing("endPos", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setIntValue(addr, ((NameTag_Type)jcasType).casFeatCode_endPos, v);}    
   
    
  //*--------------*
  //* Feature: confidenceLingpipe

  /** getter for confidenceLingpipe - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidenceLingpipe() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_confidenceLingpipe == null)
      jcasType.jcas.throwFeatMissing("confidenceLingpipe", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((NameTag_Type)jcasType).casFeatCode_confidenceLingpipe);}
    
  /** setter for confidenceLingpipe - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidenceLingpipe(double v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_confidenceLingpipe == null)
      jcasType.jcas.throwFeatMissing("confidenceLingpipe", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((NameTag_Type)jcasType).casFeatCode_confidenceLingpipe, v);}    
   
    
  //*--------------*
  //* Feature: confidenceAbner

  /** getter for confidenceAbner - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidenceAbner() {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_confidenceAbner == null)
      jcasType.jcas.throwFeatMissing("confidenceAbner", "edu.cmu.deiis.types.NameTag");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((NameTag_Type)jcasType).casFeatCode_confidenceAbner);}
    
  /** setter for confidenceAbner - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidenceAbner(double v) {
    if (NameTag_Type.featOkTst && ((NameTag_Type)jcasType).casFeat_confidenceAbner == null)
      jcasType.jcas.throwFeatMissing("confidenceAbner", "edu.cmu.deiis.types.NameTag");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((NameTag_Type)jcasType).casFeatCode_confidenceAbner, v);}    
  }

    