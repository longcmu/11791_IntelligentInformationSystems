package edu.cmu.deiis.types;

/* First created by JCasGen Mon Sep 29 11:54:27 EDT 2014 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Thu Oct 02 12:25:08 EDT 2014
 * @generated */
public class NameTag_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NameTag_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NameTag_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NameTag(addr, NameTag_Type.this);
  			   NameTag_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NameTag(addr, NameTag_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NameTag.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.NameTag");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_beginPos;
  /** @generated */
  final int     casFeatCode_beginPos;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getBeginPos(int addr) {
        if (featOkTst && casFeat_beginPos == null)
      jcas.throwFeatMissing("beginPos", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getIntValue(addr, casFeatCode_beginPos);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setBeginPos(int addr, int v) {
        if (featOkTst && casFeat_beginPos == null)
      jcas.throwFeatMissing("beginPos", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setIntValue(addr, casFeatCode_beginPos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_endPos;
  /** @generated */
  final int     casFeatCode_endPos;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getEndPos(int addr) {
        if (featOkTst && casFeat_endPos == null)
      jcas.throwFeatMissing("endPos", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getIntValue(addr, casFeatCode_endPos);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEndPos(int addr, int v) {
        if (featOkTst && casFeat_endPos == null)
      jcas.throwFeatMissing("endPos", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setIntValue(addr, casFeatCode_endPos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidenceLingpipe;
  /** @generated */
  final int     casFeatCode_confidenceLingpipe;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidenceLingpipe(int addr) {
        if (featOkTst && casFeat_confidenceLingpipe == null)
      jcas.throwFeatMissing("confidenceLingpipe", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidenceLingpipe);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidenceLingpipe(int addr, double v) {
        if (featOkTst && casFeat_confidenceLingpipe == null)
      jcas.throwFeatMissing("confidenceLingpipe", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidenceLingpipe, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidenceAbner;
  /** @generated */
  final int     casFeatCode_confidenceAbner;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidenceAbner(int addr) {
        if (featOkTst && casFeat_confidenceAbner == null)
      jcas.throwFeatMissing("confidenceAbner", "edu.cmu.deiis.types.NameTag");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidenceAbner);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidenceAbner(int addr, double v) {
        if (featOkTst && casFeat_confidenceAbner == null)
      jcas.throwFeatMissing("confidenceAbner", "edu.cmu.deiis.types.NameTag");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidenceAbner, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NameTag_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_beginPos = jcas.getRequiredFeatureDE(casType, "beginPos", "uima.cas.Integer", featOkTst);
    casFeatCode_beginPos  = (null == casFeat_beginPos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_beginPos).getCode();

 
    casFeat_endPos = jcas.getRequiredFeatureDE(casType, "endPos", "uima.cas.Integer", featOkTst);
    casFeatCode_endPos  = (null == casFeat_endPos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_endPos).getCode();

 
    casFeat_confidenceLingpipe = jcas.getRequiredFeatureDE(casType, "confidenceLingpipe", "uima.cas.Double", featOkTst);
    casFeatCode_confidenceLingpipe  = (null == casFeat_confidenceLingpipe) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidenceLingpipe).getCode();

 
    casFeat_confidenceAbner = jcas.getRequiredFeatureDE(casType, "confidenceAbner", "uima.cas.Double", featOkTst);
    casFeatCode_confidenceAbner  = (null == casFeat_confidenceAbner) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidenceAbner).getCode();

  }
}



    