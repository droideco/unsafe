package io.github.droideco.unsafe;

import android.os.Build;

import java.lang.reflect.Field;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * The package name notwithstanding, this class is the quasi-standard
 * way for Java code to gain access to and use functionality which,
 * when unsupervised, would allow one to break the pointer/type safety
 * of Java.
 */
public class Unsafe {

    /**
     * This class is only privately instantiable.
     */
    private Unsafe() {
    }

    private static final class SingletonHolder {
        private SingletonHolder() {
            throw new AssertionError("No io.github.droideco.unsafe.Unsafe$SingletonHolder instances for you!");
        }
        public static final Unsafe UNSAFE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? new SDK24() : new Unsafe();
    }

    /**
     * Gets the unique instance of this class.
     */
    public static Unsafe getUnsafe() {
        return SingletonHolder.UNSAFE;
    }

    protected static final sun.misc.Unsafe UNSAFE;
    static {
        sun.misc.Unsafe _unsafe;
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            _unsafe = (sun.misc.Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            try {
                Field field = sun.misc.Unsafe.class.getDeclaredField("THE_ONE");
                field.setAccessible(true);
                _unsafe = (sun.misc.Unsafe) field.get(null);
            }
            catch (NoSuchFieldException ex) {
                _unsafe = null;
            }
            catch (IllegalAccessException ex) {
                _unsafe = null;
            }
        } catch (IllegalAccessException e) {
            _unsafe = null;
        }
        if (_unsafe == null) throw new IllegalStateException("Failed to get the sun.misc.Unsafe instance");
        else UNSAFE = _unsafe;
    }

    /**
     * Gets the offset from the start of an array object's memory to
     * the memory used to store its initial (zeroeth) element.
     *
     * @param clazz non-null; class in question; must be an array class
     * @return the offset to the initial element
     */
    public int arrayBaseOffset(Class<?> clazz) {
        return UNSAFE.arrayBaseOffset(clazz);
    }

    /**
     * Gets the size of each element of the given array class.
     *
     * @param clazz non-null; class in question; must be an array class
     * @return &gt; 0; the size of each element of the array
     */
    public int arrayIndexScale(Class<?> clazz) {
        return UNSAFE.arrayIndexScale(clazz);
    }

    /**
     * Performs a compare-and-set operation on an <code>int</code>
     * field within the given object.
     *
     * @param obj           non-null; object containing the field
     * @param offset        offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue      new value to store in the field if the contents are
     *                      as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    public boolean compareAndSwapInt(Object obj, long offset, int expectedValue, int newValue) {
        return UNSAFE.compareAndSwapInt(obj, offset, expectedValue, newValue);
    }

    /**
     * Performs a compare-and-set operation on a <code>long</code>
     * field within the given object.
     *
     * @param obj           non-null; object containing the field
     * @param offset        offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue      new value to store in the field if the contents are
     *                      as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    public boolean compareAndSwapLong(Object obj, long offset, long expectedValue, long newValue) {
        return UNSAFE.compareAndSwapLong(obj, offset, expectedValue, newValue);
    }

    /**
     * Performs a compare-and-set operation on an <code>Object</code>
     * field (that is, a reference field) within the given object.
     *
     * @param obj           non-null; object containing the field
     * @param offset        offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue      new value to store in the field if the contents are
     *                      as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    public boolean compareAndSwapObject(Object obj, long offset, Object expectedValue, Object newValue) {
        return UNSAFE.compareAndSwapObject(obj, offset, expectedValue, newValue);
    }

    /**
     * Gets an <code>int</code> field from the given object.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public int getInt(Object obj, long offset) {
        return UNSAFE.getInt(obj, offset);
    }

    /**
     * Gets an <code>int</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public int getIntVolatile(Object obj, long offset) {
        return UNSAFE.getIntVolatile(obj, offset);
    }

    /**
     * Gets a <code>long</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public long getLong(Object obj, long offset) {
        return UNSAFE.getLong(obj, offset);
    }

    /**
     * Gets a <code>long</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public long getLongVolatile(Object obj, long offset) {
        return UNSAFE.getLongVolatile(obj, offset);
    }

    /**
     * Gets an <code>Object</code> field from the given object.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public Object getObject(Object obj, long offset) {
        return UNSAFE.getObject(obj, offset);
    }

    /**
     * Gets an <code>Object</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj    non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    public Object getObjectVolatile(Object obj, long offset) {
        return UNSAFE.getObjectVolatile(obj, offset);
    }

    /**
     * Gets the raw byte offset from the start of an object's memory to
     * the memory used to store the indicated instance field.
     *
     * @param field non-null; the field in question, which must be an
     *              instance field
     * @return the offset to the field
     */
    public long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    /**
     * Parks the calling thread for the specified amount of time,
     * unless the "permit" for the thread is already available (due to
     * a previous call to {@link #unpark}. This method may also return
     * spuriously (that is, without the thread being told to unpark
     * and without the indicated amount of time elapsing).
     * <p>
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * @param absolute whether the given time value is absolute
     *                 milliseconds-since-the-epoch (<code>true</code>) or relative
     *                 nanoseconds-from-now (<code>false</code>)
     * @param time     the (absolute millis or relative nanos) time value
     */
    public void park(boolean absolute, long time) {
        UNSAFE.park(absolute, time);
    }

    /**
     * Unparks the given object, which must be a {@link Thread}.
     * <p>
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * @param obj non-null; the object to unpark
     */
    public void unpark(Object obj) {
        UNSAFE.unpark(obj);
    }

    /**
     * Stores an <code>int</code> field into the given object.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putInt(Object obj, long offset, int newValue) {
        UNSAFE.putInt(obj, offset, newValue);
    }

    /**
     * Stores an <code>int</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putIntVolatile(Object obj, long offset, int newValue) {
        UNSAFE.putIntVolatile(obj, offset, newValue);
    }

    /**
     * Stores a <code>long</code> field into the given object.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putLong(Object obj, long offset, long newValue) {
        UNSAFE.putLong(obj, offset, newValue);
    }

    /**
     * Stores a <code>long</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putLongVolatile(Object obj, long offset, long newValue) {
        UNSAFE.putLongVolatile(obj, offset, newValue);
    }

    /**
     * Stores an <code>Object</code> field into the given object.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putObject(Object obj, long offset, Object newValue) {
        UNSAFE.putObject(obj, offset, newValue);
    }

    /**
     * Stores an <code>Object</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj      non-null; object containing the field
     * @param offset   offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    public void putObjectVolatile(Object obj, long offset, Object newValue) {
        UNSAFE.putObjectVolatile(obj, offset, newValue);
    }

    /**
     * Lazy set an int field.
     */
    public void putOrderedInt(Object obj, long offset, int newValue) {
        UNSAFE.putOrderedInt(obj, offset, newValue);
    }

    /**
     * Lazy set a long field.
     */
    public void putOrderedLong(Object obj, long offset, long newValue) {
        UNSAFE.putOrderedLong(obj, offset, newValue);
    }

    /**
     * Lazy set an object field.
     */
    public void putOrderedObject(Object obj, long offset, Object newValue) {
        UNSAFE.putOrderedObject(obj, offset, newValue);
    }

    static {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) System.loadLibrary("unsafe");
    }
    private static native Object nAllocateInstance(Class<?> clazz) throws InstantiationException;
    @CriticalNative
    private static native int nAddressSize();
    private static native int nPageSize();
    private static native long nAllocateMemory(long bytes);
    private static native void nFreeMemory(long address);
    private static native void nSetMemory(long address, long bytes, byte value);
    @FastNative
    private static native boolean nGetBoolean(Object obj, long offset);
    @FastNative
    private static native void nPutBoolean(Object obj, long offset, boolean newValue);
    @FastNative
    private static native byte nGetByte(Object obj, long offset);
    @CriticalNative
    private static native byte nGetByte(long address);
    @FastNative
    private static native void nPutByte(Object obj, long offset, byte newValue);
    @CriticalNative
    private static native void nPutByte(long address, byte newValue);
    @FastNative
    private static native short nGetShort(Object obj, long offset);
    @CriticalNative
    private static native short nGetShort(long address);
    @FastNative
    private static native void nPutShort(Object obj, long offset, short newValue);
    @CriticalNative
    private static native void nPutShort(long address, short newValue);
    @FastNative
    private static native char nGetChar(Object obj, long offset);
    @CriticalNative
    private static native char nGetChar(long address);
    @FastNative
    private static native void nPutChar(Object obj, long offset, char newValue);
    @CriticalNative
    private static native void nPutChar(long address, char newValue);
    @CriticalNative
    private static native int nGetInt(long address);
    @CriticalNative
    private static native void nPutInt(long address, int newValue);
    @CriticalNative
    private static native long nGetLong(long address);
    @CriticalNative
    private static native void nPutLong(long address, long newValue);
    @FastNative
    private static native float nGetFloat(Object obj, long offset);
    @CriticalNative
    private static native float nGetFloat(long address);
    @FastNative
    private static native void nPutFloat(Object obj, long offset, float newValue);
    @CriticalNative
    private static native void nPutFloat(long address, float newValue);
    @FastNative
    private static native double nGetDouble(Object obj, long offset);
    @CriticalNative
    private static native double nGetDouble(long address);
    @FastNative
    private static native void nPutDouble(Object obj, long offset, double newValue);
    @CriticalNative
    private static native void nPutDouble(long address, double newValue);
    private static native void nCopyMemory(long srcAddr, long dstAddr, long bytes);
    @CriticalNative
    private static native void nLoadFence();
    @CriticalNative
    private static native void nStoreFence();
    @CriticalNative
    private static native void nFullFence();

    /**
     * Allocates an instance of the given class without running the constructor.
     * The class' &lt;clinit&gt; will be run, if necessary.
     */
    @SuppressWarnings("unchecked")
    public <T> T allocateInstance(Class<T> clazz) throws InstantiationException {
        return (T) nAllocateInstance(clazz);
    }

    public int addressSize() {
        return nAddressSize();
    }

    public int pageSize() {
        return nPageSize();
    }

    public long allocateMemory(long bytes) {
        return nAllocateMemory(bytes);
    }

    public void freeMemory(long address) {
        nFreeMemory(address);
    }

    public void setMemory(long address, long bytes, byte value) {
        nSetMemory(address, bytes, value);
    }

    public boolean getBoolean(Object obj, long offset) {
        return nGetBoolean(obj, offset);
    }

    public void putBoolean(Object obj, long offset, boolean newValue) {
        nPutBoolean(obj, offset, newValue);
    }

    public byte getByte(Object obj, long offset) {
        return nGetByte(obj, offset);
    }

    public byte getByte(long address) {
        return nGetByte(address);
    }

    public void putByte(Object obj, long offset, byte newValue) {
        nPutByte(obj, offset, newValue);
    }

    public void putByte(long address, byte newValue) {
        nPutByte(address, newValue);
    }

    public short getShort(Object obj, long offset) {
        return nGetShort(obj, offset);
    }

    public short getShort(long address) {
        return nGetShort(address);
    }

    public void putShort(Object obj, long offset, short newValue) {
        nPutShort(obj, offset, newValue);
    }

    public void putShort(long address, short newValue) {
        nPutShort(address, newValue);
    }

    public char getChar(Object obj, long offset) {
        return nGetChar(obj, offset);
    }

    public char getChar(long address) {
        return nGetChar(address);
    }

    public void putChar(Object obj, long offset, char newValue) {
        nPutChar(obj, offset, newValue);
    }

    public void putChar(long address, char newValue) {
        nPutChar(address, newValue);
    }

    public int getInt(long address) {
        return nGetInt(address);
    }

    public void putInt(long address, int newValue) {
        nPutInt(address, newValue);
    }

    public long getLong(long address) {
        return nGetLong(address);
    }

    public void putLong(long address, long newValue) {
        nPutLong(address, newValue);
    }

    public float getFloat(Object obj, long offset) {
        return nGetFloat(obj, offset);
    }

    public float getFloat(long address) {
        return nGetFloat(address);
    }

    public void putFloat(Object obj, long offset, float newValue) {
        nPutFloat(obj, offset, newValue);
    }

    public void putFloat(long address, float newValue) {
        nPutFloat(address, newValue);
    }

    public double getDouble(Object obj, long offset) {
        return nGetDouble(obj, offset);
    }

    public double getDouble(long address) {
        return nGetDouble(address);
    }

    public void putDouble(long address, double newValue) {
        nPutDouble(address, newValue);
    }

    public void putDouble(Object obj, long offset, double newValue) {
        nPutDouble(obj, offset, newValue);
    }

    public void copyMemory(long srcAddr, long dstAddr, long bytes) {
        nCopyMemory(srcAddr, dstAddr, bytes);
    }

    // The following contain CAS-based Java implementations used on
    // platforms not supporting native instructions

    /**
     * Atomically adds the given value to the current value of a field
     * or array element within the given object {@code o}
     * at the given {@code offset}.
     *
     * @param o      object/array to update the field/element in
     * @param offset field/element offset
     * @param delta  the value to add
     * @return the previous value
     */
    public int getAndAddInt(Object o, long offset, int delta) {
        int v;
        do {
            v = getIntVolatile(o, offset);
        } while (!compareAndSwapInt(o, offset, v, v + delta));
        return v;
    }

    /**
     * Atomically adds the given value to the current value of a field
     * or array element within the given object {@code o}
     * at the given {@code offset}.
     *
     * @param o      object/array to update the field/element in
     * @param offset field/element offset
     * @param delta  the value to add
     * @return the previous value
     */
    public long getAndAddLong(Object o, long offset, long delta) {
        long v;
        do {
            v = getLongVolatile(o, offset);
        } while (!compareAndSwapLong(o, offset, v, v + delta));
        return v;
    }

    /**
     * Atomically exchanges the given value with the current value of
     * a field or array element within the given object {@code o}
     * at the given {@code offset}.
     *
     * @param o        object/array to update the field/element in
     * @param offset   field/element offset
     * @param newValue new value
     * @return the previous value
     */
    public int getAndSetInt(Object o, long offset, int newValue) {
        int v;
        do {
            v = getIntVolatile(o, offset);
        } while (!compareAndSwapInt(o, offset, v, newValue));
        return v;
    }

    /**
     * Atomically exchanges the given value with the current value of
     * a field or array element within the given object {@code o}
     * at the given {@code offset}.
     *
     * @param o        object/array to update the field/element in
     * @param offset   field/element offset
     * @param newValue new value
     * @return the previous value
     */
    public long getAndSetLong(Object o, long offset, long newValue) {
        long v;
        do {
            v = getLongVolatile(o, offset);
        } while (!compareAndSwapLong(o, offset, v, newValue));
        return v;
    }

    /**
     * Atomically exchanges the given reference value with the current
     * reference value of a field or array element within the given
     * object {@code o} at the given {@code offset}.
     *
     * @param o        object/array to update the field/element in
     * @param offset   field/element offset
     * @param newValue new value
     * @return the previous value
     */
    public Object getAndSetObject(Object o, long offset, Object newValue) {
        Object v;
        do {
            v = getObjectVolatile(o, offset);
        } while (!compareAndSwapObject(o, offset, v, newValue));
        return v;
    }

    /**
     * Ensures that loads before the fence will not be reordered with loads and
     * stores after the fence; a "LoadLoad plus LoadStore barrier".
     * <p>
     * Corresponds to C11 atomic_thread_fence(memory_order_acquire)
     * (an "acquire fence").
     * <p>
     * A pure LoadLoad fence is not provided, since the addition of LoadStore
     * is almost always desired, and most current hardware instructions that
     * provide a LoadLoad barrier also provide a LoadStore barrier for free.
     */
    public void loadFence() {
        nLoadFence();
    }

    /**
     * Ensures that loads and stores before the fence will not be reordered with
     * stores after the fence; a "StoreStore plus LoadStore barrier".
     * <p>
     * Corresponds to C11 atomic_thread_fence(memory_order_release)
     * (a "release fence").
     * <p>
     * A pure StoreStore fence is not provided, since the addition of LoadStore
     * is almost always desired, and most current hardware instructions that
     * provide a StoreStore barrier also provide a LoadStore barrier for free.
     */
    public void storeFence() {
        nStoreFence();
    }

    /**
     * Ensures that loads and stores before the fence will not be reordered
     * with loads and stores after the fence.  Implies the effects of both
     * loadFence() and storeFence(), and in addition, the effect of a StoreLoad
     * barrier.
     * <p>
     * Corresponds to C11 atomic_thread_fence(memory_order_seq_cst).
     */
    public void fullFence() {
        nFullFence();
    }

    private static final long ADDRESS_SIZE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? UNSAFE.addressSize() : nAddressSize();
    private static final class ReferenceLayout {
        public Object base;
        public Object diff;
    }
    private static final long REFERENCE_SIZE;
    static {
        long _referenceSize;
        try {
            _referenceSize = Math.abs(UNSAFE.objectFieldOffset(ReferenceLayout.class.getDeclaredField("base"))
                    - UNSAFE.objectFieldOffset(ReferenceLayout.class.getDeclaredField("diff")));
        } catch (NoSuchFieldException e) {
            _referenceSize = ADDRESS_SIZE;
        }
        REFERENCE_SIZE = _referenceSize;
    }
    

    private interface Int64Adapter {
        long get(Object obj, long offset);
        long get(long address);
        void put(Object obj, long offset, long newValue);
        void put(long address, long newValue);
        Int64Adapter SIZE32 = new Int64Adapter() {
            @Override
            public long get(Object obj, long offset) {
                return UNSAFE.getInt(obj, offset) & 0xFFFFFFFFL;
            }
            @Override
            public long get(long address) {
                return UNSAFE.getInt(address) & 0xFFFFFFFFL;
            }
            @Override
            public void put(Object obj, long offset, long newValue) {
                UNSAFE.putInt(obj, offset, (int) newValue);
            }
            @Override
            public void put(long address, long newValue) {
                UNSAFE.putInt(address, (int) newValue);
            }
        };
        Int64Adapter SIZE64 = new Int64Adapter() {
            @Override
            public long get(Object obj, long offset) {
                return UNSAFE.getLong(obj, offset);
            }
            @Override
            public long get(long address) {
                return UNSAFE.getLong(address);
            }
            @Override
            public void put(Object obj, long offset, long newValue) {
                UNSAFE.putLong(obj, offset, newValue);
            }
            @Override
            public void put(long address, long newValue) {
                UNSAFE.putLong(address, newValue);
            }
        };
        Int64Adapter ADDRESS = ADDRESS_SIZE == 8L ? Int64Adapter.SIZE64 : Int64Adapter.SIZE32;
        Int64Adapter REFERENCE = REFERENCE_SIZE == 8L ? Int64Adapter.SIZE64 : Int64Adapter.SIZE32;
    }

    private static final ThreadLocal<Object[]> BUFFER = new ThreadLocal<>() {
        @Override
        protected Object[] initialValue() {
            return new Object[1];
        }
    };
    private static long nAddressOf(Object obj) {
        Object[] buffer = BUFFER.get();
        buffer[0] = obj;
        try {
            return Int64Adapter.REFERENCE.get(buffer, UNSAFE.arrayBaseOffset(Object[].class));
        }
        finally {
            buffer[0] = null;
        }
    }

    public long addressOf(Object obj) {
        return nAddressOf(obj);
    }

    public long getAddress(Object obj, long offset) {
        return Int64Adapter.ADDRESS.get(obj, offset);
    }

    public long getAddress(long address) {
        return Int64Adapter.ADDRESS.get(address);
    }

    public void putAddress(Object obj, long offset, long newValue) {
        Int64Adapter.ADDRESS.put(obj, offset, newValue);
    }

    public void putAddress(long address, long newValue) {
        Int64Adapter.ADDRESS.put(address, newValue);
    }

    private static final class SDK24 extends Unsafe {

        @SuppressWarnings("unchecked")
        @Override
        public <T> T allocateInstance(Class<T> clazz) throws InstantiationException {
            return (T) UNSAFE.allocateInstance(clazz);
        }

        @Override
        public int addressSize() {
            return UNSAFE.addressSize();
        }

        @Override
        public int pageSize() {
            return UNSAFE.pageSize();
        }

        /*
        @Override
        public long allocateMemory(long bytes) {
            return UNSAFE.allocateMemory(bytes);
        }

        @Override
        public void freeMemory(long address) {
            UNSAFE.freeMemory(address);
        }
         */

        @Override
        public void setMemory(long address, long bytes, byte value) {
            UNSAFE.setMemory(address, bytes, value);
        }

        @Override
        public boolean getBoolean(Object obj, long offset) {
            return UNSAFE.getBoolean(obj, offset);
        }

        @Override
        public void putBoolean(Object obj, long offset, boolean newValue) {
            UNSAFE.putBoolean(obj, offset, newValue);
        }

        @Override
        public byte getByte(Object obj, long offset) {
            return UNSAFE.getByte(obj, offset);
        }

        @Override
        public byte getByte(long address) {
            return UNSAFE.getByte(address);
        }

        @Override
        public void putByte(Object obj, long offset, byte newValue) {
            UNSAFE.putByte(obj, offset, newValue);
        }

        @Override
        public void putByte(long address, byte newValue) {
            UNSAFE.putByte(address, newValue);
        }

        @Override
        public short getShort(Object obj, long offset) {
            return UNSAFE.getShort(obj, offset);
        }

        @Override
        public short getShort(long address) {
            return UNSAFE.getShort(address);
        }

        @Override
        public void putShort(Object obj, long offset, short newValue) {
            UNSAFE.putShort(obj, offset, newValue);
        }

        @Override
        public void putShort(long address, short newValue) {
            UNSAFE.putShort(address, newValue);
        }

        @Override
        public char getChar(Object obj, long offset) {
            return UNSAFE.getChar(obj, offset);
        }

        @Override
        public char getChar(long address) {
            return UNSAFE.getChar(address);
        }

        @Override
        public void putChar(Object obj, long offset, char newValue) {
            UNSAFE.putChar(obj, offset, newValue);
        }

        @Override
        public void putChar(long address, char newValue) {
            UNSAFE.putChar(address, newValue);
        }

        @Override
        public int getInt(long address) {
            return UNSAFE.getInt(address);
        }

        @Override
        public void putInt(long address, int newValue) {
            UNSAFE.putInt(address, newValue);
        }

        @Override
        public long getLong(long address) {
            return UNSAFE.getLong(address);
        }

        @Override
        public void putLong(long address, long newValue) {
            UNSAFE.putLong(address, newValue);
        }

        @Override
        public float getFloat(Object obj, long offset) {
            return UNSAFE.getFloat(obj, offset);
        }

        @Override
        public float getFloat(long address) {
            return UNSAFE.getFloat(address);
        }

        @Override
        public void putFloat(Object obj, long offset, float newValue) {
            UNSAFE.putFloat(obj, offset, newValue);
        }

        @Override
        public void putFloat(long address, float newValue) {
            UNSAFE.putFloat(address, newValue);
        }

        @Override
        public double getDouble(Object obj, long offset) {
            return UNSAFE.getDouble(obj, offset);
        }

        @Override
        public double getDouble(long address) {
            return UNSAFE.getDouble(address);
        }

        @Override
        public void putDouble(Object obj, long offset, double newValue) {
            UNSAFE.putDouble(obj, offset, newValue);
        }

        @Override
        public void putDouble(long address, double newValue) {
            UNSAFE.putDouble(address, newValue);
        }

        @Override
        public void copyMemory(long srcAddr, long dstAddr, long bytes) {
            UNSAFE.copyMemory(srcAddr, dstAddr, bytes);
        }

        /*
        @Override
        public int getAndAddInt(Object o, long offset, int delta) {
            return UNSAFE.getAndAddInt(o, offset, delta);
        }

        @Override
        public long getAndAddLong(Object o, long offset, long delta) {
            return UNSAFE.getAndAddLong(o, offset, delta);
        }

        @Override
        public int getAndSetInt(Object o, long offset, int newValue) {
            return UNSAFE.getAndSetInt(o, offset, newValue);
        }

        @Override
        public long getAndSetLong(Object o, long offset, long newValue) {
            return UNSAFE.getAndSetLong(o, offset, newValue);
        }

        @Override
        public Object getAndSetObject(Object o, long offset, Object newValue) {
            return UNSAFE.getAndSetObject(o, offset, newValue);
        }
         */

        @Override
        public void loadFence() {
            UNSAFE.loadFence();
        }

        @Override
        public void storeFence() {
            UNSAFE.storeFence();
        }

        @Override
        public void fullFence() {
            UNSAFE.fullFence();
        }

    }

}
