=begin
#move.mil API

#The Prime API for move.mil

OpenAPI spec version: 0.0.1
Contact: dp3@truss.works
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 2.4.13

=end

require 'date'

module SwaggerClient
  class CustomerContactType
    
    FIRST = 'FIRST'.freeze
    SECOND = 'SECOND'.freeze

    # Builds the enum from string
    # @param [String] The enum value in the form of the string
    # @return [String] The enum value
    def build_from_hash(value)
      constantValues = CustomerContactType.constants.select { |c| CustomerContactType::const_get(c) == value }
      raise "Invalid ENUM value #{value} for class #CustomerContactType" if constantValues.empty?
      value
    end
  end
end
