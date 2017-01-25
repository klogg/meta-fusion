DESCRIPTION = "FUSION recipe for Aarch64 kernels"

require recipes-kernel/linux/linux-yocto.inc

# Skip processing of this recipe if it is not explicitly specified as the
# PREFERRED_PROVIDER for virtual/kernel. This avoids errors when trying
# to build multiple virtual/kernel providers, e.g. as dependency of
# core-image-rt-sdk, core-image-rt.
python () {
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel", True) != "linux-fusion":
        raise bb.parse.SkipPackage("Set PREFERRED_PROVIDER_virtual/kernel to linux-fusion to enable it")
}

SRCREV_machine ?= "13e7680774d9103bb2685635238bcf577a52ff96"
SRCREV_meta ?= "83110d94edeb856a3667b62903ed4ae91c24117d"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/horms/renesas-bsp.git;protocol=http;name=machine;branch=v4.9/rcar-3.5.1; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.8;destsuffix=${KMETA}"

LINUX_VERSION ?= "4.9.0"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

LINUX_KERNEL_TYPE = "preempt-rt"

COMPATIBLE_MACHINE = "xenaarch64"
