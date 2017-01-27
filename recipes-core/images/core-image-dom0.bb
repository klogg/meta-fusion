# Simple initramfs image. Mostly used for live images.
DESCRIPTION = "Generic xen dom0 vm image capable of booting other VMs as \
configured. RAM-based Initial Root Filesystem (initramfs) is used to avoid \
need for accessing block/mtd devices. Shall contain kernel images for other \
VMs."

PACKAGE_INSTALL = "initramfs-live-boot ${VIRTUAL-RUNTIME_base-utils} udev base-passwd ${ROOTFS_BOOTSTRAP_INSTALL} xen-base xen-flask"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "core-image-dom0"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

BAD_RECOMMENDATIONS += "busybox-syslog"
