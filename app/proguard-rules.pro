# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepattributes LineNumberTable,SourceFile
-renamesourcefileattribute SourceFile
-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*
-keepattributes InnerClasses, EnclosingMethod
-printmapping out.map

# Retrofit
-dontwarn retrofit2.**
-keep,allowobfuscation,allowshrinking class retrofit2.** { *; }
-keep,allowobfuscation,allowshrinking interface retrofit2.** { *; }

# OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-keep,allowobfuscation,allowshrinking class okhttp3.** { *; }
-keep,allowobfuscation,allowshrinking interface okhttp3.** { *; }

# Gson
-keep class com.google.gson.** { *; }
-keepnames class com.google.gson.** { *; }
-keep class com.google.gson.reflect.TypeToken { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
    @com.google.gson.annotations.SerializedName <methods>;
}

-keep class java.lang.reflect.** { *; }

-keepclassmembers class com.google.gson.reflect.TypeToken {
    <init>(java.lang.reflect.Type);
    <init>(java.lang.reflect.Type, java.lang.reflect.Type[]);
    <fields>;
    <methods>;
}

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation