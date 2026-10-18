# GAC1_com.yftech.service.upgrade.apk

> Decompiled source repository for `com.yftech.service.upgrade.apk`.

## Summary

- **APK file name**: `com.yftech.service.upgrade.apk`
- **Package name**: `com.yftech.service.upgrade`
- **Version**: `?` (versionCode `?`)
- **Min SDK**: `26`  |  **Target SDK**: `29`
- **Total decompiled classes**: `1073`
- **Decompiled on**: 2026-10-18 12:17:13 UTC
- **Source repo**: [ammisaidkaidi/yftech-apks](https://github.com/ammisaidkaidi/yftech-apks)

## What this app does (inferred)

- Background service component
- OTA firmware / app upgrade pipeline
- Upgrade / OTA service
- Boot-time startup (auto-starts on device boot)

Inference is based on the APK file name, package name, declared permissions, registered services/receivers, and top-level Java package structure. Manual review of the source under `jadx_out/sources/` is recommended for definitive behavior.

## Permissions

- `android.permission.RECEIVE_BOOT_COMPLETED`  (RECEIVE_BOOT_COMPLETED)
- `android.permission.RECOVERY`  (RECOVERY)

## App components (from AndroidManifest.xml)

**Application class**: `com.yftech.service.upgrade.CarApplication`
**Launcher activity**: `(none found)`

### Activities (1)

- `com.yftech.service.upgrade.MainActivity`

### Services (1)

- `com.yftech.service.upgrade.CarUpgradeService`

### Broadcast receivers (1)

- `com.yftech.service.upgrade.receiver.CarBootReceiver`

### Content providers (0)

- (none)

## Java package structure

**Top-level packages**: `a`, `android`, `androidx`, `com`

**Detected third-party libraries**:

- Android framework (system)  (1 top-level entries)
- Android Jetpack (AndroidX libraries)  (1 top-level entries)

**Custom (non-library) packages — depth 2**:

- `a.a`
- `com.google`
- `com.google.android`
- `com.google.android.material`
- `com.yftech`
- `com.yftech.service`
- `com.yftech.service.upgrade`

## Key classes & method signatures

Per custom package, the top-level classes (up to 8 each) and their first few public method signatures.

### `a.a`  (6 class files in this folder)

- **class `a`**  (`a.java`, ~107 lines)

- **class `b`**  (`b.java`, ~48 lines)

- **class `c`**  (`c.java`, ~11 lines)

- **class `d`**  (`d.java`, ~8 lines)

- **class `e`**  (`e.java`, ~97 lines)
  - `void a(...)`
  - `byte[] a(...)`
  - `byte[] a(...)`
  - `ByteBuffer b(...)`
  - `ByteBuffer b(...)`

- **class `f`**  (`f.java`, ~164 lines)
  - `String a(...)`
  - `String a(...)`
  - `void a(...)`
  - `void a(...)`
  - `void a(...)`
  - `String b(...)`
  - `String b(...)`
  - `void b(...)`
  - `void b(...)`
  - `void b(...)`

### `com.google`  (0 class files in this folder)

(no top-level classes in this package)

### `com.google.android`  (0 class files in this folder)

(no top-level classes in this package)

### `com.google.android.material`  (1 class file in this folder)

- **class `a`**  (`a.java`, ~3608 lines)

### `com.yftech`  (0 class files in this folder)

(no top-level classes in this package)

### `com.yftech.service`  (0 class files in this folder)

(no top-level classes in this package)

### `com.yftech.service.upgrade`  (8 class files in this folder)

- **class `CarApplication`**  (`CarApplication.java`, ~26 lines)
  - `void onCreate(...)`
  - `void run(...)`
  - `void onTerminate(...)`

- **class `CarUpgradeService`**  (`CarUpgradeService.java`, ~795 lines)
  - `void a(...)`
  - `void b(...)`
  - `void run(...)`
  - `void onUpgradeState(...)`
  - `void a(...)`
  - `void run(...)`
  - `int addUpgradeModule(...)`
  - `boolean checkUpgradeFile(...)`
  - `CarUpgradeInfo getCurUpgradeingInfo(...)`
  - `int[] getHasAddUpgradeModule(...)`
  - `String getVersion(...)`
  - `void registerListener(...)`
  - `int removeUpgradeModule(...)`
  - `boolean startUpgrade(...)`
  - `void unregisterListener(...)`

- **class `MainActivity`**  (`MainActivity.java`, ~374 lines)
  - `void onUpgradeProgress(...)`
  - `void onUpgradeState(...)`
  - `void a(...)`
  - `void b(...)`
  - `void onCheckedChanged(...)`
  - `void onClick(...)`

- **class `is`**  (`R.java`, ~2944 lines)

- **class `a`**  (`a.java`, ~14 lines)

- **interface `b`**  (`b.java`, ~27 lines)

- **class `c`**  (`c.java`, ~12 lines)

- **class `d`**  (`d.java`, ~4506 lines)

## Decompilation methodology

This repo was produced by the following pipeline:

1. **APK download** — raw file fetched via the GitHub raw URL (no repo clone).
2. **apktool d** — decoded `AndroidManifest.xml`, resources (`res/`), `assets/`, native libs (`lib/`), and produced `apktool.yml` metadata.
3. **jadx -d** — produced Java-readable decompiled sources under `jadx_out/sources/`.
4. **Static analysis pass** — parsed manifest + walked `jadx_out/sources/` to enumerate packages, classes, methods, and detect known third-party libraries.
5. **README auto-generation** — produced this file with the static analysis results.

### Reproducing

```bash
# 1) download the APK (raw, no clone)
curl -L -o com.yftech.service.upgrade.apk \
  'https://raw.githubusercontent.com/ammisaidkaidi/yftech-apks/main/com.yftech.service.upgrade.apk'

# 2) decode resources + manifest
apktool d -f -o apktool_out com.yftech.service.upgrade.apk

# 3) decompile to Java-readable sources
jadx -d jadx_out --no-res com.yftech.service.upgrade.apk
```

> Note: `--no-res` is passed to jadx because apktool already decoded resources.

## Directory layout

``
GAC1_com.yftech.service.upgrade.apk/
├── README.md                  <- this file
├── com.yftech.service.upgrade.apk                 <- original APK binary
├── apktool_out/               <- apktool output (resources, manifest, smali)
└── jadx_out/                  <- jadx output (Java-readable sources)
```

### apktool_out/
```
├── AndroidManifest.xml
├── apktool.yml
├── assets/
│   ├── default.properties
│   └── default_8015.properties
├── lib/
│   ├── arm64-v8a/
│   └── armeabi-v7a/
├── original/
│   ├── AndroidManifest.xml
│   └── META-INF/
├── res/
│   ├── anim/
│   ├── animator/
│   ├── color/
│   ├── drawable/
│   ├── drawable-hdpi/
│   ├── drawable-ldrtl-hdpi/
│   ├── drawable-ldrtl-mdpi/
│   ├── drawable-ldrtl-xhdpi/
│   ├── drawable-ldrtl-xxhdpi/
│   ├── drawable-ldrtl-xxxhdpi/
│   ├── drawable-mdpi/
│   ├── drawable-watch/
│   ├── drawable-xhdpi/
│   ├── drawable-xxhdpi/
│   ├── drawable-xxxhdpi/
│   ├── interpolator/
│   ├── layout/
│   ├── layout-land/
│   ├── layout-sw600dp/
│   └── layout-watch/
│   └── ... (108 more entries)
├── smali/
│   ├── a/
│   ├── android/
│   ├── androidx/
│   └── com/
└── unknown/
    └── META-INF/
```

### jadx_out/
```
├── resources/
└── sources/
    ├── a/
    ├── android/
    ├── androidx/
    └── com/
```

## Disclaimer

This repository contains decompiled (reverse-engineered) Java source code and resources derived from a binary APK. Decompilation was performed for research, interoperability, and educational purposes.

- The decompiled code is **not** the original source — variable names, comments, generics, and some control flow may have been lost or simplified during compilation/decompilation.
- All trademarks, copyrights, and IP belong to their respective owners (YF Tech / 御驾 (YF) Automotive).
- The author of this repo does not host the original APK on this repo's remote — only the decompiled artifacts. The original APK is publicly listed at the source repository cited above.
- This repository is for **analysis only**. Do not use it to redistribute or rebuild the original application.