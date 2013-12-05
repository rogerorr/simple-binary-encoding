/* Generated SBE (Simple Binary Encoding) message codec */
#ifndef _VARDATAENCODING_HPP_
#define _VARDATAENCODING_HPP_

#include "sbe/sbe.hpp"

using namespace sbe;

namespace uk_co_real_logic_sbe_ir_generated {

class VarDataEncoding : public FixedFlyweight
{
private:
    char *buffer_;
    int offset_;
    int actingVersion_;

public:
    VarDataEncoding &wrap(char *buffer, const int offset, const int actingVersion)
    {
        buffer_ = buffer;
        offset_ = offset;
        actingVersion_ = actingVersion;
        return *this;
    };

    static int size(void)
    {
        return -1;
    };


    sbe_uint8_t length(void) const
    {
        return (*((sbe_uint8_t *)(buffer_ + offset_ + 0)));
    };

    VarDataEncoding &length(const sbe_uint8_t value)
    {
        *((sbe_uint8_t *)(buffer_ + offset_ + 0)) = (value);
        return *this;
    };
};
}
#endif