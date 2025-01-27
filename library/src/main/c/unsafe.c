#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdatomic.h>

JNIEXPORT jlong JNICALL
nAddressOf(JNIEnv *env, __attribute__((unused)) jclass clazz, jobject obj);

JNIEXPORT jobject JNICALL
nAllocateInstance(JNIEnv *env, __attribute__((unused)) jclass clazz, jclass clazz_1) {
    return (*env)->AllocObject(env, clazz_1);
}

JNIEXPORT jint JNICALL
nAddressSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(void *);
}

JNIEXPORT jint JNICALL
nPageSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sysconf(_SC_PAGESIZE);
}

JNIEXPORT jlong JNICALL
nAllocateMemory(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong bytes) {
    return (jlong) malloc((size_t) bytes);
}

JNIEXPORT void JNICALL
nFreeMemory(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    free((void *) address);
}

JNIEXPORT void JNICALL
nSetMemory(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                 jlong bytes, jbyte value) {
    memset((void *) address, value, bytes);
}

JNIEXPORT jboolean JNICALL
nGetBoolean(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jboolean *) (object + (size_t) offset));
}

JNIEXPORT void JNICALL
nPutBoolean(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jboolean new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jboolean *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT jbyte JNICALL
nGetByte__Ljava_lang_Object_2J(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jbyte *) (object + (size_t) offset));
}

JNIEXPORT jbyte JNICALL
nGetByte__J(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jbyte *) address);
}

JNIEXPORT void JNICALL
nPutByte__Ljava_lang_Object_2JB(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jbyte new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jbyte *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT void JNICALL
nPutByte__JB(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                   jbyte new_value) {
    *((jbyte *) address) = new_value;
}

JNIEXPORT jshort JNICALL
nGetShort__Ljava_lang_Object_2J(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jshort *) (object + (size_t) offset));
}

JNIEXPORT jshort JNICALL
nGetShort__J(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jshort *) address);
}

JNIEXPORT void JNICALL
nPutShort__Ljava_lang_Object_2JS(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jshort new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jshort *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT void JNICALL
nPutShort__JS(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                    jshort new_value) {
    *((jshort *) address) = new_value;
}

JNIEXPORT jchar JNICALL
nGetChar__Ljava_lang_Object_2J(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jchar *) (object + (size_t) offset));
}

JNIEXPORT jchar JNICALL
nGetChar__J(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jchar *) address);
}

JNIEXPORT void JNICALL
nPutChar__Ljava_lang_Object_2JC(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jchar new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jchar *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT void JNICALL
nPutChar__JC(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                   jchar new_value) {
    *((jchar *) address) = new_value;
}

JNIEXPORT jint JNICALL
nGetInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jint *) address);
}

JNIEXPORT void JNICALL
nPutInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                              jint new_value) {
    *((jint *) address) = new_value;
}

JNIEXPORT jlong JNICALL
nGetLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jlong *) address);
}

JNIEXPORT void JNICALL
nPutLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                               jlong new_value) {
    *((jlong *) address) = new_value;
}

JNIEXPORT jfloat JNICALL
nGetFloat__Ljava_lang_Object_2J(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jfloat *) (object + (size_t) offset));
}

JNIEXPORT jfloat JNICALL
nGetFloat__J(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jfloat *) address);
}

JNIEXPORT void JNICALL
nPutFloat__Ljava_lang_Object_2JF(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jfloat new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jfloat *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT void JNICALL
nPutFloat__JF(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                    jfloat new_value) {
    *((jfloat *) address) = new_value;
}

JNIEXPORT jdouble JNICALL
nGetDouble__Ljava_lang_Object_2J(JNIEnv *env, jclass clazz, jobject obj, jlong offset) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    return *((jdouble *) (object + (size_t) offset));
}

JNIEXPORT jdouble JNICALL
nGetDouble__J(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jdouble *) address);
}

JNIEXPORT void JNICALL
nPutDouble__Ljava_lang_Object_2JD(JNIEnv *env, jclass clazz, jobject obj, jlong offset, jdouble new_value) {
    const int8_t *object = (int8_t *) nAddressOf(env, clazz, obj);
    *((jdouble *) (object + (size_t) offset)) = new_value;
}

JNIEXPORT void JNICALL
nPutDouble__JD(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                     jdouble new_value) {
    *((jdouble *) address) = new_value;
}

JNIEXPORT void JNICALL
nCopyMemory(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong src_addr,
                                                  jlong dst_addr, jlong bytes) {
    memcpy((void *) dst_addr, (const void *) src_addr, (size_t) bytes);
}

JNIEXPORT void JNICALL
nLoadFence(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    atomic_thread_fence(memory_order_acquire);
}

JNIEXPORT void JNICALL
nStoreFence(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    atomic_thread_fence(memory_order_release);
}

JNIEXPORT void JNICALL
nFullFence(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    atomic_thread_fence(memory_order_seq_cst);
}

static jmethodID nAddressOf_methodID;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, __attribute__((unused)) void *reserved) {
    JNIEnv *env;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) return JNI_ERR;
    jclass clazz = (*env)->FindClass(env, "io/github/droideco/unsafe/Unsafe");
    if (clazz == NULL) return JNI_ERR;
    if (android_get_device_api_level() < __ANDROID_API_N__) {
        JNINativeMethod methods[] = {
                {"nAllocateInstance", "(Ljava/lang/Class;)Ljava/lang/Object;", &nAllocateInstance},
                {"nAddressSize", "!()I", &nAddressSize},
                {"nPageSize", "()I", &nPageSize},
                {"nAllocateMemory", "(J)J", &nAllocateMemory},
                {"nFreeMemory", "(J)V", &nFreeMemory},
                {"nSetMemory", "(JJB)V", &nSetMemory},
                {"nGetBoolean", "!(Ljava/lang/Object;J)Z", &nGetBoolean},
                {"nPutBoolean", "!(Ljava/lang/Object;JZ)V", &nPutBoolean},
                {"nGetByte", "!(Ljava/lang/Object;J)B", &nGetByte__Ljava_lang_Object_2J},
                {"nGetByte", "!(J)B", &nGetByte__J},
                {"nPutByte", "!(Ljava/lang/Object;JB)V", nPutByte__Ljava_lang_Object_2JB},
                {"nPutByte", "!(JB)V", &nPutByte__JB},
                {"nGetShort", "!(Ljava/lang/Object;J)S", &nGetShort__Ljava_lang_Object_2J},
                {"nGetShort", "!(J)S", &nGetShort__J},
                {"nPutShort", "!(Ljava/lang/Object;JS)V", &nPutShort__Ljava_lang_Object_2JS},
                {"nPutShort", "!(JS)V", &nPutShort__JS},
                {"nGetChar", "!(Ljava/lang/Object;J)C", &nGetChar__Ljava_lang_Object_2J},
                {"nGetChar", "!(J)C", &nGetChar__J},
                {"nPutChar", "!(Ljava/lang/Object;JC)V", &nPutChar__Ljava_lang_Object_2JC},
                {"nPutChar", "!(JC)V", &nPutChar__JC},
                {"nGetInt", "!(J)I", &nGetInt},
                {"nPutInt", "!(JI)V", &nPutInt},
                {"nGetLong", "!(J)J", &nGetLong},
                {"nPutLong", "!(JJ)V", &nPutLong},
                {"nGetFloat", "!(Ljava/lang/Object;J)F", &nGetFloat__Ljava_lang_Object_2J},
                {"nGetFloat", "!(J)F", &nGetFloat__J},
                {"nPutFloat", "!(Ljava/lang/Object;JF)V", &nPutFloat__Ljava_lang_Object_2JF},
                {"nPutFloat", "!(JF)V", &nPutFloat__JF},
                {"nGetDouble", "!(Ljava/lang/Object;J)D", &nGetDouble__Ljava_lang_Object_2J},
                {"nGetDouble", "!(J)D", &nGetDouble__J},
                {"nPutDouble", "!(Ljava/lang/Object;JD)V", &nPutDouble__Ljava_lang_Object_2JD},
                {"nPutDouble", "!(JD)V", &nPutDouble__JD},
                {"nCopyMemory", "(JJJ)V", &nCopyMemory},
                {"nLoadFence", "!()V", &nLoadFence},
                {"nStoreFence", "!()V", &nStoreFence},
                {"nFullFence", "!()V", &nFullFence}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) != JNI_OK) return JNI_ERR;
    }
    else {
        JNINativeMethod methods[] = {
                {"nAllocateMemory", "(J)J", &nAllocateMemory},
                {"nFreeMemory", "(J)V", &nFreeMemory}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) != JNI_OK) return JNI_ERR;
    }
    nAddressOf_methodID = (*env)->GetStaticMethodID(env, clazz, "nAddressOf", "(Ljava/lang/Object;)J");
    if (nAddressOf_methodID == NULL) return JNI_ERR;
    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL
JNI_OnUnload(__attribute__((unused)) JavaVM* vm, __attribute__((unused)) void* reserved) {
    nAddressOf_methodID = NULL;
}

JNIEXPORT jlong JNICALL
nAddressOf(JNIEnv *env, jclass clazz, jobject obj) {
    return (*env)->CallStaticLongMethod(env, clazz, nAddressOf_methodID, obj);
}

#ifdef __cplusplus
}
#endif
