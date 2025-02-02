-keepclasseswithmembernames, includedescriptorclasses class io.github.droideco.unsafe.Unsafe {
    native <methods>;
}

-keep class io.github.droideco.unsafe.Unsafe {
    long nAddressOf(java.lang.Object);
}
